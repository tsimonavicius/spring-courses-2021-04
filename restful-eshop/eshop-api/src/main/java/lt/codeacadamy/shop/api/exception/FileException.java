package lt.codeacadamy.shop.api.exception;

import lombok.Getter;

/**
 * @author Andrius Baltrunas
 */
@Getter
public class FileException extends RuntimeException {
    private final String message;

    public FileException(String message) {
        super(message);
        this.message = message;
    }
}
