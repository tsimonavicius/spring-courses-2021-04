package lt.codeacademy.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 50, message = "{validation.size.name}")
    private String name;

    @PositiveOrZero
    @Max(1000)
    @NotNull
    private Integer quantity;

    @Positive
    @NotNull
    private BigDecimal price;

    @Size(max = 255)
    private String description;
}
