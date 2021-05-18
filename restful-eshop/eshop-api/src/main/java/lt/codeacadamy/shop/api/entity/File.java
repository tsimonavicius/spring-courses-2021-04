package lt.codeacadamy.shop.api.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Entity
@Getter
@Setter
public class File {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String fileName;

    @Column(columnDefinition = "VARCHAR(30)")
    private String mediaType;

    @Column(columnDefinition = "int")
    private long size;

    @CreationTimestamp
    private LocalDateTime timestamp = LocalDateTime.now();
}
