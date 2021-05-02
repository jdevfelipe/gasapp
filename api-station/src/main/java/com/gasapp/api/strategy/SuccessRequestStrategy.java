package com.gasapp.api.strategy;

import com.gasapp.api.factory.Factory;
import com.gasapp.api.factory.FactoryStation;
import com.gasapp.api.models.Station;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

public class SuccessRequestStrategy implements Strategy {

    private FactoryStation factory = new FactoryStation();

    @Override
    public List<Station> build(Elements elements) {

        return factory.factoryStation(elements);
    }
}
