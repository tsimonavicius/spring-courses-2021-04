package lt.codeacademy.eshop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
//    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String name;

    private Integer quantity;

    private BigDecimal price;

    private String description;
}
