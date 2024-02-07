package schoolSoftware.school.student.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Integer id){
        super("Could not find student with this " + id);
    }
}
