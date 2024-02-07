package schoolSoftware.school.student_parent.exception;

public class Student_ParentNotFoundException extends RuntimeException{
    public Student_ParentNotFoundException(Integer id){
        super("Could not find student_parent with this " + id);
    }
}
