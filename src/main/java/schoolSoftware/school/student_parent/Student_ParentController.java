package schoolSoftware.school.student_parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_ParentController {

    @Autowired
    private  Student_ParentRepository repository;

    @PostMapping("/student_parent")
    Student_ParentModel newStudent_Parent(@RequestBody Student_ParentModel newStudent_Parent) {
        return repository.save(newStudent_Parent);
    }

}
