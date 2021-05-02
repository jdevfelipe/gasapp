package com.gasapp.api.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
