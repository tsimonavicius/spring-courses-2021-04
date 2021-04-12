package lt.codeacademy.eshop.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {

    private UUID id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private String description;
}
