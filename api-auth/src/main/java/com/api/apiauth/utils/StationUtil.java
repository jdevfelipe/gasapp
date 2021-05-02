package com.api.apiauth.utils;

import com.api.apiauth.models.Station;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StationUtil {
    public void removeProceHistoric(List<Station> stations) {
        for (Station s:
             stations) {
            s.setPrices(new ArrayList<>());
        }
    }
}
