package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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
    public Page<Expence_Entity> retrieveAllExpences(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return expenceRepository.findAll(pageable);
        
		// return expenceService.retrieveAll();
		// return expenceRepository.findAll();
    }


    @GetMapping("/expences/{id}")
    public Optional<Expence_Entity> retrieveSpecificExpence(@PathVariable int id) {
        // return expenceService.retrieveFromId(id);
    	return expenceRepository.findById(id);
    }

    @DeleteMapping("/expences/{id}")
    public void deleteSpecificExpence(@PathVariable int id) {
         // expenceService.deleteFromId(id);
    	Optional<Expence_Entity> existingExpence = expenceRepository.findById(id);
    	
    	if(existingExpence.isPresent()) {
    		expenceRepository.deleteById(id);
    	}
    	
    	else {
    		throw new RuntimeException("Expence not found with ID = " + id); 
    	}
    }

    @PostMapping("/expences")
    public Expence_Entity addExpence(@Valid @RequestBody Expence_Entity entity) {
        // return expenceService.addExpence(entity);
    	return expenceRepository.save(entity);
    }
    
    @PutMapping("/expences/{id}")
    public Expence_Entity updateExpence(@PathVariable int id,  @Valid @RequestBody Expence_Entity entity) {
    	Optional<Expence_Entity> existingExpence = expenceRepository.findById(id);
    	
    	if(existingExpence.isPresent()) {
    		Expence_Entity expence = existingExpence.get();
    		
    		expence.setId(id);
    		expence.setTitle(entity.getTitle());
    		expence.setAmount(entity.getAmount());
    		expence.setCategory(entity.getCategory());
    		expence.setDate(entity.getDate());
    	
        	return expenceRepository.save(expence);
    	}
    	
    	else {
    		throw new RuntimeException("Expence not found with ID = " + id); 
    	}
    	
    }
    
    @GetMapping("/expences/category/{category}")
    public List<Expence_Entity> retrieveByCategory(@PathVariable String category) {
        // return expenceService.retrieveFromId(id);
    	return expenceRepository.findByCategory(category);
    }
    
}
