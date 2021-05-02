package com.gasapp.api.jobs;

import com.gasapp.api.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class UpdatePricesJob {

    private static final String TIME_ZONE = "America/Sao_Paulo";
    @Autowired

    private RequestService service;


    @Scheduled(cron = "0 0 3 * * *", zone = TIME_ZONE)
    public void updatePrices() throws Exception {
        System.out.println("CRONNN: " + LocalDateTime.now());
        service.request("");
    }

}
