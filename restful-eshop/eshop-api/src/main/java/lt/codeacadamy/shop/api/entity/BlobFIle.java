package lt.codeacadamy.shop.api.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrius Baltrunas
 */
@Getter
@Setter
public class BlobFIle extends File {

    private byte[] bytes;
}
