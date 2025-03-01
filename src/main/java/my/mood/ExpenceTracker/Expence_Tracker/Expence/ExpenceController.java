package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenceController {

//    @Autowired
//     ExpenceService expenceService;

    @Autowired
    ExpenceRepository expenceRepository;
    
    public ExpenceController(/*ExpenceService expenceService,*/ ExpenceRepository expenceRepository) {
//         this.expenceService = expenceService;
        this.expenceRepository = expenceRepository;
    }

    @GetMapping("/expences")
    public List<Expence_Entity> retrieveAllExpences() {
        // return expenceService.retrieveAll();
    	return expenceRepository.findAll();
    }

    @GetMapping("/expences/{id}")
    public Optional<Expence_Entity> retrieveSpecificExpence(@PathVariable int id) {
        // return expenceService.retrieveFromId(id);
    	return expenceRepository.findById(id);
    }

    @DeleteMapping("/expences/{id}")
    public void deleteSpecificExpence(@PathVariable int id) {
         // expenceService.deleteFromId(id);
    	expenceRepository.deleteById(id);
    }

    @PostMapping("/expences")
    public Expence_Entity addExpence(@RequestBody Expence_Entity entity) {
        // return expenceService.addExpence(entity);
    	return expenceRepository.save(entity);
    }
    
}
