package nz.co.automation.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogNotFoundException extends RuntimeException {
    public DogNotFoundException(Integer id) {
        super(format("Unable to find dog with id %s", id));
    }
}
