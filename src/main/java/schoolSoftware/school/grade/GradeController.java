package schoolSoftware.school.grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolSoftware.school.grade.exception.GradeNotFoundException;

@RestController
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;

    @PostMapping("/grade")
    GradeModel newGrade(@RequestBody GradeModel newGrade) {
        return gradeRepository.save(newGrade);
    }

    @GetMapping("/grade")
    Iterable<GradeModel> all() {
        return gradeRepository.findAll();
    }

    @GetMapping("/grade/{id}")
    GradeModel find(@PathVariable Integer id){
        return this.gradeRepository.findById(id)
                .orElseThrow(()->
                        new GradeNotFoundException(id));
    }

    @DeleteMapping("/grade/{id}")
    String delete(@PathVariable Integer id){
        if(!gradeRepository.existsById(id)){
            throw new GradeNotFoundException(id);
        }
        gradeRepository.deleteById(id);
        return "Grade with id " + id + " has been deleted.";
    }

    @PutMapping("/grade/{id}")
    GradeModel replaceGrade(@RequestBody GradeModel newGrade, @PathVariable Integer id){
        return gradeRepository.findById(id).map(grade ->{
            grade.setGname(newGrade.getGname());
            grade.setGlevel(newGrade.getGlevel());
            return gradeRepository.save(grade);
        }).orElseThrow(() -> new GradeNotFoundException(id));
    }

}
