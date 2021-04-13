package lt.codeacademy.eshop.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    private Integer quantity;

    private BigDecimal price;

    private String description;
}
