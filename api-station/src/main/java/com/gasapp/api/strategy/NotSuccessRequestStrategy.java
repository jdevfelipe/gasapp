package com.gasapp.api.strategy;

import com.gasapp.api.exceptions.RequestNotSuccessException;
import com.gasapp.api.models.Station;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.List;

public class NotSuccessRequestStrategy implements Strategy {
    private static final String REQUEST_NOT_SUCCESS = "REQUEST_NOT_SUCCESS";


    @Override
    public List<Station> build(Elements elements) {
        //TODO implementar sendgrid para avisar falha
        throw new RequestNotSuccessException(REQUEST_NOT_SUCCESS);
    }
}
