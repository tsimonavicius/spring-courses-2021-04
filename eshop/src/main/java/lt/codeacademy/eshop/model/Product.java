package lt.codeacademy.eshop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank(message = "Name negali būti tuščias")
    @Size(
            min = 3,
            max = 50,
            message = "Name='${validatedValue}' turi būti daugiau už {min} ir mažiau už {max}")
    private String name;

    @PositiveOrZero
    @Max(1000)
    private Integer quantity;

    @Positive
    private BigDecimal price;

    @Size(max = 255)
    private String description;
}
