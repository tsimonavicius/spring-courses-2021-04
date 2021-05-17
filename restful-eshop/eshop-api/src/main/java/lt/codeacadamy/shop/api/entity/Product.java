package lt.codeacadamy.shop.api.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "Product UUID", value = "UUID default value", name = "id")
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 50, message = "{validation.size.name}")
    @ApiModelProperty(notes = "Product name", required = true, value = "default name", name = "name")
    private String name;

    @PositiveOrZero
    @Max(1000)
    @NotNull
    //@ApiModelProperty(notes = "Product quantity", required = true, name = "quantity")
    private Integer quantity;

    @Positive
    @NotNull
    //@ApiModelProperty(notes = "Product price", required = true, name = "price")
    private BigDecimal price;

    @Size(max = 255)
    @ApiModelProperty(notes = "Product description", required = true, value = "default description", name = "description")
    private String description;
}
