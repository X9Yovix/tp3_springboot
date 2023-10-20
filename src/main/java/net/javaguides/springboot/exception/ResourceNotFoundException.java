package net.javaguides.springboot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String r, String fN, Object fV) {
        super(String.format("%s not found with %s : '%s'", r, fN, fV));
        this.resourceName = r;
        this.fieldName = fN;
        this.fieldValue = fV;
    }
}
