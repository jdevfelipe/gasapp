package com.gasapp.api.factory;

import com.gasapp.api.dtos.AddressDTO;
import com.gasapp.api.dtos.PriceDTO;
import com.gasapp.api.exceptions.RequestNotSuccessException;
import com.gasapp.api.models.Station;
import com.gasapp.api.utils.Util;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class FactoryStation implements Factory {
    private static final String REQUEST_NOT_SUCCESS = "REQUEST_NOT_SUCCESS";

    private Util util;

    @Override
    public HttpURLConnection factoryRequest(String cookie) throws IOException {
        return null;
    }

    @Override
    public List<Station> factoryStation(Elements elements) {
        if (elements.size() < 2) {
            throw new RequestNotSuccessException(REQUEST_NOT_SUCCESS);
        }

        Elements tableHeaderEles = elements.first().select("tbody tr th");

        Elements tableRowElements = elements.first().select(":not(tbody) tr");

        List<Station> stationList = new ArrayList<>();

        for (int i = 0; i < tableRowElements.size(); i++) {
            Element row = tableRowElements.get(i);
            System.out.println("row");
            Elements rowItems = row.select("td");

            if (rowItems.isEmpty()) {
                continue;
            }

            if (rowItems.size() < 7) {
                Station station = defaultConstructor(rowItems);
                stationList.add(station);
            }
        }
        return stationList;
    }

    public Station defaultConstructor(Elements rowItems) {
        Station station = new Station();

        station.setNameNoCaps(StringUtils.isBlank(rowItems.get(0).text()) ? null : rowItems.get(0).text().toLowerCase());
        station.setName(StringUtils.isBlank(rowItems.get(0).text()) ? null : rowItems.get(0).text());

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(StringUtils.isBlank(rowItems.get(1).text()) ? null : rowItems.get(1).text());
        addressDTO.setDistrict(StringUtils.isBlank(rowItems.get(2).text()) ? null : rowItems.get(2).text());

        station.setAddress(addressDTO);

        station.setFlag(StringUtils.isBlank(rowItems.get(3).text()) ? null : rowItems.get(3).text());

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setPrice(StringUtils.isBlank(rowItems.get(4).text()) ? 0 : Float.parseFloat(rowItems.get(4).text().replace(",", ".")));
        station.setLastPrice(priceDTO.getPrice());
        util = new Util();
        priceDTO.setDateTime(util.stringToLocalDate(rowItems.get(5).text()));

        List<PriceDTO> priceDTOList = new ArrayList<>();
        priceDTOList.add(priceDTO);
        station.setPrices(priceDTOList);

        return station;

    }
}
