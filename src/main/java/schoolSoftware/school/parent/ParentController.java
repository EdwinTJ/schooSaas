package schoolSoftware.school.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schoolSoftware.school.parent.exception.ParentNotFound;

import java.util.List;

@RestController
public class ParentController {
    @Autowired
    private ParentRepository parentRepository;

    @PostMapping("/parent")
    ParentModel newParent(@RequestBody ParentModel newParent) {
        return parentRepository.save(newParent);
    }

    @GetMapping("/parent")
    List<ParentModel> all() {
        return parentRepository.findAll();
    }

    @GetMapping("/parent/{id}")
    ParentModel find(@PathVariable Integer id){
        return this.parentRepository.findById(id)
                .orElseThrow(()->
                        new ParentNotFound(id));
    }

    @DeleteMapping("/parent/{id}")
    String delete(@PathVariable Integer id){
        if(!parentRepository.existsById(id)){
            throw new ParentNotFound(id);
        }
        parentRepository.deleteById(id);
        return "Parent with id " + id + " has been deleted.";
    }

    @PutMapping("/parent/{id}")
    ParentModel replaceParent(@RequestBody ParentModel newParent, @PathVariable Integer id){
        return parentRepository.findById(id).map(parent ->{
            parent.setFname(newParent.getFname());
            parent.setLname(newParent.getLname());
            parent.setPhone(newParent.getPhone());
            parent.setEmail(newParent.getEmail());
            return parentRepository.save(parent);
        }).orElseThrow(() -> new ParentNotFound(id));
    }
}