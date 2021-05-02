package com.gasapp.api.factory;

import com.gasapp.api.models.Station;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

@Component
public interface Factory {
    HttpURLConnection factoryRequest(String cookie) throws IOException;
    List<Station> factoryStation(Elements elements);
}
