package schoolSoftware.school.grade.exception;


public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(Integer id) {
        super("Could not find grade with this " + id);
    }
}
