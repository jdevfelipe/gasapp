package com.gasapp.api.strategy;

import com.gasapp.api.models.Station;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface Strategy {
    List<Station> build(Elements elements) throws Exception;
}
