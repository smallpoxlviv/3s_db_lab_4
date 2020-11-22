package ua.iot.lviv.model;

import java.math.BigDecimal;
import java.text.NumberFormat;

public interface Service extends GeneralModel {
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    BigDecimal getPriceUSD();
    void setPriceUSD(BigDecimal priceUSD);
}
