package schoolSoftware.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolSoftware.school.student.exception.StudentNotFoundException;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    StudentModel newStudent(@RequestBody StudentModel newStudent) {
        return studentRepository.save(newStudent);
    }

    @GetMapping("/student")
    List<StudentModel> all() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    StudentModel find(@PathVariable Integer id){
        return this.studentRepository.findById(id)
                .orElseThrow(()->
                        new StudentNotFoundException(id));
    }

    @DeleteMapping("/student/{id}")
    String delete(@PathVariable Integer id){
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "Student with id " + id + " has been deleted.";
    }

    @PutMapping("/student/{id}")
    StudentModel replaceStudent(@RequestBody StudentModel newStudent, @PathVariable Integer id){
        return studentRepository.findById(id).map(student ->{
            student.setFname(newStudent.getFname());
            student.setLname(newStudent.getLname());
            return studentRepository.save(student);
        }).orElseThrow(() -> new StudentNotFoundException(id));
    }
}
