package schoolSoftware.school.parent.exception;

public class ParentNotFound  extends RuntimeException{
    public ParentNotFound(Integer id){
        super("Could not find parent with this " + id);
    }

}