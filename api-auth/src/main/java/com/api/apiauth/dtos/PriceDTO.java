package com.api.apiauth.dtos;

import java.time.LocalDate;

public class PriceDTO {
    private float price;
    private LocalDate dateTime;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }
}
