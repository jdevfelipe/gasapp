package com.gasapp.api.services;

import com.gasapp.api.dtos.PriceDTO;
import com.gasapp.api.factory.Factory;
import com.gasapp.api.factory.FactoryRequest;
import com.gasapp.api.factory.FactoryRequestDate;
import com.gasapp.api.models.Station;
import com.gasapp.api.repositories.StationRepository;
import com.gasapp.api.strategy.NotSuccessRequestStrategy;
import com.gasapp.api.strategy.Strategy;
import com.gasapp.api.strategy.SuccessRequestStrategy;
import com.gasapp.api.utils.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

@Service
public class RequestService {
    @Autowired
    private Util util;

    @Autowired
    private StationRepository repository;

    private Strategy strategy;

    private Factory request;

    public void request(String cookie) throws Exception {

        request = new FactoryRequestDate();

        String dataDate = "Acao=";

        byte[] outDate = dataDate.getBytes(StandardCharsets.UTF_8);

        HttpURLConnection httpDate = request.factoryRequest("");

        OutputStream streamDate = httpDate.getOutputStream();

        streamDate.write(outDate);

        String responseDate = util.inputStreamToString(httpDate.getInputStream());

        Document docDate = Jsoup.parse(responseDate);

        Elements inputsWeekDate = docDate.select("input[name=desc_Semana]");

        Elements inputsWeekCode = docDate.select("input[name=cod_Semana]");

        if (inputsWeekDate.size() < 3 || inputsWeekCode.size() < 3) {
            strategy = new NotSuccessRequestStrategy();
        }

        String firstLetter = inputsWeekDate.val().substring(0, 1).toUpperCase();

        String date = inputsWeekDate.val().replace("/", "%2F").replace(" ", "+").replace("d", firstLetter);

        String code = inputsWeekCode.val();

        request = new FactoryRequest();

        HttpURLConnection http = request.factoryRequest(cookie);

        String data = "cod_semana=" + code + "&desc_semana=" + date + "&cod_combustivel=487&desc_combustivel=+-+GASOLINA+COMUM+R%24%2Fl&selMunicipio=6015*CURITIBA&tipo=1";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();

        stream.write(out);

        String response = util.inputStreamToString(http.getInputStream());

        Document doc = Jsoup.parse(response);

        Elements tableElements = doc.select("table");

        if (tableElements.size() < 3) {
            strategy = new NotSuccessRequestStrategy();
        } else {
            strategy = new SuccessRequestStrategy();
        }

        save(strategy.build(tableElements));

        http.disconnect();
    }

    public void save(List<Station> stationList) {
        for (Station s :
                stationList) {
            if (!Objects.isNull(s)) {
                Station station = repository.findByNameNoCaps(s.getNameNoCaps());

                if(!Objects.isNull(station)) {
                    List<PriceDTO> priceDTOList = station.getPrices();

                    priceDTOList.addAll(s.getPrices());

                    s.setPrices(priceDTOList);

                    s.setId(station.getId());
                }
            }

            repository.save(s);
        }
    }
}
