package dto;

import java.io.Serializable;

public class StockDTO implements Serializable  {
    private Long productCode;
    private Integer quantity;

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
