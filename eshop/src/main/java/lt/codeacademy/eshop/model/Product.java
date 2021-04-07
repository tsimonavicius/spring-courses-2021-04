package lt.codeacademy.eshop.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String description;
}
