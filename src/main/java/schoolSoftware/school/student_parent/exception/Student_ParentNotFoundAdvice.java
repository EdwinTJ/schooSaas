package schoolSoftware.school.student_parent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ControllerAdvice
public class Student_ParentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(Student_ParentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(Student_ParentNotFoundException exception) {
        return Map.of("error", exception.getMessage());
    }
}
