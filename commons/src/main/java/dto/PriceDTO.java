package dto;

import java.io.Serializable;

public class PriceDTO implements Serializable  {
    private Long productCode;
    private Double price;

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
