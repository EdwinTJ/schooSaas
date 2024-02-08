package schoolSoftware.school.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolSoftware.school.teacher.exception.TeacherNotFoundException;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("/teacher")
    public TeacherModel addTeacher(TeacherModel teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping("/teacher")
    public List<TeacherModel> getTeachers() {
        return teacherRepository.findAll();
    }
    @GetMapping("/teacher/{id}")
    public TeacherModel getTeacher(Integer id) {
        return teacherRepository.findById(id).orElseThrow(()->new TeacherNotFoundException(id));
    }

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(Integer id) {
        if(!teacherRepository.existsById(id)){
            throw new TeacherNotFoundException(id);
        }
        teacherRepository.deleteById(id);
        return "Teacher with id " + id + " has been deleted.";
    }

    @PutMapping("/teacher/{id}")
    public TeacherModel replaceTeacher(TeacherModel newTeacher, Integer id) {
        return teacherRepository.findById(id).map(teacher ->{
            teacher.setFname(newTeacher.getFname());
            teacher.setLname(newTeacher.getLname());
            teacher.setEmail(newTeacher.getEmail());
            return teacherRepository.save(teacher);
        }).orElseThrow(() -> new TeacherNotFoundException(id));
    }
}
