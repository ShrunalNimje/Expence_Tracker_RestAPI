package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import my.mood.ExpenceTracker.Expence_Tracker.DTO.ExpenceCreateDTO;
import my.mood.ExpenceTracker.Expence_Tracker.DTO.ExpenceUpdateDTO;

@RestController
@Tag(name = "Expense Tracker RestAPI", description = "Create, Delete, Update and Retrieve Expenses")
public class ExpenceController {

    @Autowired
     ExpenceService expenceService;

    @Autowired
    ExpenceRepository expenceRepository;
    
    public ExpenceController(ExpenceService expenceService, ExpenceRepository expenceRepository) {
        this.expenceService = expenceService;
        this.expenceRepository = expenceRepository;
    }
    
    // It will retrieve all the expenses
    @Operation(summary = "Retrieve all expenses", description = "It will return all expenses of logged-in user")
    @GetMapping("/expences")
    public Page<Expence_Entity> retrieveAllExpences(Pageable pageable) {
        return expenceService.retrieveAll(pageable);
    }

    // It will retrieve a specific expense provided by id
    @Operation(summary = "Retrieve an expense", description = "It will return an expense by unique id")
    @GetMapping("/expences/{id}")
    public Optional<Expence_Entity> retrieveSpecificExpence(@PathVariable int id) {
        return expenceService.retrieveFromId(id);
    }

    // It will delete a specific expense provided by id
    @Operation(summary = "Delete an expense", description = "It will delete an expense by unique id")
    @DeleteMapping("/expences/{id}")
    public ResponseEntity<String> deleteSpecificExpence(@PathVariable int id) {
         return expenceService.deleteFromId(id); 
    }

    // It will create or add an expense
    @Operation(summary = "Add an expense", description = "It will add new expense")
    @PostMapping("/expences")
    public ResponseEntity<String> addExpence(@Valid @RequestBody ExpenceCreateDTO entity) {
        return expenceService.addExpence(entity);
    }
    
    // It will update the existing expense provided by id
    @Operation(summary = "Update an expense", description = "It will update an expense by unique id")
    @PutMapping("/expences/{id}")
    public ResponseEntity<String> updateExpence(@PathVariable int id,  @Valid @RequestBody ExpenceUpdateDTO entity) {
    	return expenceService.updateExpence(id, entity);
    	
    }
    
    // It will retrieve all the expenses provided by category
    @Operation(summary = "Retrieve all expenses by category", description = "It will return all expenses by providing category")
    @GetMapping("/expences/category/{category}")
    public List<Expence_Entity> retrieveByCategory(@PathVariable String category) {
        return expenceService.retrieveByCategory(category);
    }
    
}
