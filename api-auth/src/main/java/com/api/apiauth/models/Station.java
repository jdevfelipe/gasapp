package com.api.apiauth.models;

import com.api.apiauth.dtos.AddressDTO;
import com.api.apiauth.dtos.PriceDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "stations")
public class Station {
    @Id
    private String id;
    private String nameNoCaps;
    private String name;
    private AddressDTO address;
    private String flag;
    private List<PriceDTO> prices;
    private float lastPrice;
    //TODO precisa adicionar array de combustiveis e passar array de preços para dentro de cada objeto combustivel

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameNoCaps() {
        return nameNoCaps;
    }

    public void setNameNoCaps(String nameNoCaps) {
        this.nameNoCaps = nameNoCaps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<PriceDTO> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceDTO> prices) {
        this.prices = prices;
    }

    public float getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(float lastPrice) {
        this.lastPrice = lastPrice;
    }
}
