package com.gasapp.api.factory;

import com.gasapp.api.models.Station;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class FactoryRequest implements Factory {
    @Override
    public HttpURLConnection factoryRequest(String cookie) throws IOException {

        if (StringUtils.isBlank(cookie)) {
            cookie = "";
        }

        URL url = new URL("https://preco.anp.gov.br/include/Resumo_Semanal_Posto.asp");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Connection", "keep-alive");
        http.setRequestProperty("Cache-Control", "max-age=0");
        http.setRequestProperty("sec-ch-ua", "'Google Chrome';v='89', 'Chromium';v='89', ';Not A Brand';v='99'");
        http.setRequestProperty("sec-ch-ua-mobile", "?0");
        http.setRequestProperty("Upgrade-Insecure-Requests", "1");
        http.setRequestProperty("Origin", "https://preco.anp.gov.br");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36");
        http.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        http.setRequestProperty("Sec-Fetch-Site", "same-origin");
        http.setRequestProperty("Sec-Fetch-Mode", "navigate");
        http.setRequestProperty("Sec-Fetch-User", "?1");
        http.setRequestProperty("Sec-Fetch-Dest", "document");
        http.setRequestProperty("Referer", "https://preco.anp.gov.br/include/Resumo_Por_Estado_Municipio.asp");
        http.setRequestProperty("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7");
        http.setRequestProperty("Cookie", cookie);

        return http;
    }

    @Override
    public List<Station> factoryStation(Elements elements) {
        return null;
    }
}
