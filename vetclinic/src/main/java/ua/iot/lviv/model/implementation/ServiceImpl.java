package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Service;

import java.math.BigDecimal;

public class ServiceImpl implements Service {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal priceUSD;

    public ServiceImpl(Integer id, String name, String description, BigDecimal priceUSD) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceUSD = priceUSD;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }

    @Override
    public String toString() {
        return "ServiceImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priceUSD=" + priceUSD +
                '}';
    }
}

