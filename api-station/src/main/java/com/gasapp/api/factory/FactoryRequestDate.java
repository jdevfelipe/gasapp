package com.gasapp.api.factory;

import com.gasapp.api.models.Station;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FactoryRequestDate implements Factory {
    @Override
    public HttpURLConnection factoryRequest(String cookie) throws IOException {
        URL url = new URL("https://preco.anp.gov.br/include/Resumo_Por_Estado_Index.asp");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Connection", "keep-alive");
        http.setRequestProperty("Cache-Control", "max-age=0");
        http.setRequestProperty("sec-ch-ua", "'Google Chrome';v='89', 'Chromium';v='89', ';Not'ABrand';v='99'");
        http.setRequestProperty("sec-ch-ua-mobile", "?1");
        http.setRequestProperty("Upgrade-Insecure-Requests", "1");
        http.setRequestProperty("Origin", "https://preco.anp.gov.br");
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        http.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Mobile Safari/537.36");
        http.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
        http.setRequestProperty("Sec-Fetch-Site", "same-origin");
        http.setRequestProperty("Sec-Fetch-Mode", "navigate");
        http.setRequestProperty("Sec-Fetch-User", "?1");
        http.setRequestProperty("Sec-Fetch-Dest", "document");
        http.setRequestProperty("Referer", "https://preco.anp.gov.br/");
        http.setRequestProperty("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7");
        http.setRequestProperty("Cookie", "_ga=GA1.3.836265207.1616557872; ASPSESSIONIDCGQSCTQQ=EDPIPNLDJMGBJIOHECGNOFGB; _gid=GA1.3.1080060353.1616962920; _gat_gtag_UA_141823641_1=1");

        return http;
    }

    @Override
    public List<Station> factoryStation(Elements elements) {
        return null;
    }
}
