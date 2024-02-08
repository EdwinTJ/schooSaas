package schoolSoftware.school.student_parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolSoftware.school.student_parent.exception.Student_ParentNotFoundException;

import java.util.List;

@RestController
public class Student_ParentController {

    @Autowired
    private  Student_ParentRepository repository;

    @PostMapping("/student_parent")
    Student_ParentModel newStudent_Parent(@RequestBody Student_ParentModel newStudent_Parent) {
        return repository.save(newStudent_Parent);
    }

    @GetMapping("/student_parent")
    List<Student_ParentModel> all() {
        return repository.findAll();
    }

    @GetMapping("/student_parent/{id}")
    Student_ParentModel find(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(()->
                        new Student_ParentNotFoundException(id));
    }

    @DeleteMapping("/student_parent/{id}")
    String delete(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new Student_ParentNotFoundException(id);
        }
        repository.deleteById(id);
        return "Student_Parent with id " + id + " has been deleted.";
    }


}
