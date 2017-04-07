package nz.co.automation.rest.exception;

import nz.co.automation.rest.domain.Dog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DogAlreadyExistException extends RuntimeException {

    public DogAlreadyExistException(Dog dog) {
        super(format("%s already exists!", dog));
    }
}
