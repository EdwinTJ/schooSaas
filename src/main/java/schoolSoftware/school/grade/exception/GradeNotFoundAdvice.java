package schoolSoftware.school.grade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GradeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(GradeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String exceptionHandler(GradeNotFoundException exception) {
        return exception.getMessage();
    }
}