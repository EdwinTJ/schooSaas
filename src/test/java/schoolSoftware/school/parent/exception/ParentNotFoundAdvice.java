package schoolSoftware.school.parent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class ParentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ParentNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(ParentNotFound exception) {
        return Map.of("error", exception.getMessage());
    }
}