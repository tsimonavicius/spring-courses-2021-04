package lt.codeacadamy.shop.api.advice;

import lt.codeacadamy.shop.api.exception.ExceptionResponse;
import lt.codeacadamy.shop.api.exception.FileException;
import lt.codeacadamy.shop.api.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Andrius Baltrunas
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingProductNotFoundException(ProductNotFoundException exception) {
        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handlingFileException(FileException exception){
        return new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
