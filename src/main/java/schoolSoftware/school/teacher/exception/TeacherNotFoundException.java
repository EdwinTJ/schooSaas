package schoolSoftware.school.teacher.exception;


public class TeacherNotFoundException extends RuntimeException{

    public TeacherNotFoundException(Integer id) {
        super("Could not find teacher with this " + id);
    }
}
