package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import my.mood.ExpenceTracker.Expence_Tracker.DTO.ExpenceCreateDTO;
import my.mood.ExpenceTracker.Expence_Tracker.DTO.ExpenceUpdateDTO;
import my.mood.ExpenceTracker.Expence_Tracker.Error.ExpencesNotFoundException;

@Service
public class ExpenceService {
	
	@Autowired
	ExpenceRepository expenceRepository;
	
	public ExpenceService(ExpenceRepository expenceRepository) {
		this.expenceRepository = expenceRepository;
	}
	
	// Retrieve all Expenses
	public Page<Expence_Entity> retrieveAll(Pageable pageable) {
        return expenceRepository.findAll(pageable);
	}
	
	// Retrieve a specific expense
	public Optional<Expence_Entity> retrieveFromId(int id) {
		return expenceRepository.findById(id);
	}
	
	// Delete a specific expense
	public ResponseEntity<String> deleteFromId(int id) {
		expenceRepository.findById(id)
		.orElseThrow(() -> new ExpencesNotFoundException("Expense not found with id = " + id));

		expenceRepository.deleteById(id);
		return ResponseEntity.ok("User deleted successfully with id = " + id);
	}
	
	// Add or create an expense
	public ResponseEntity<String> addExpence(ExpenceCreateDTO addEntity) {
		Expence_Entity entity = new Expence_Entity();
		
		entity.setAmount(addEntity.getAmount());
		entity.setCategory(addEntity.getCategory());
		entity.setDate(addEntity.getDate());
		entity.setTitle(addEntity.getTitle());

		expenceRepository.save(entity);
		return ResponseEntity.ok("Expense added successfully");
	}
	
	// Update an existing expense
	public ResponseEntity<String> updateExpence(int id, ExpenceUpdateDTO entity) {
		Expence_Entity existingExpense = retrieveFromId(id)
				.orElseThrow(()-> new ExpencesNotFoundException("Expense not found with id = " + id));
		
		if(entity.getAmount() != null) {
			existingExpense.setAmount(entity.getAmount());
		}
		
		if(entity.getCategory() != null) {
			existingExpense.setCategory(entity.getCategory());
		}
		
		if(entity.getTitle() != null) {
			existingExpense.setTitle(entity.getTitle());
		}
		
		if(entity.getDate() != null) {
			existingExpense.setDate(entity.getDate());
		}
		
		expenceRepository.save(existingExpense);
		
		return ResponseEntity.ok("Expense Updated successfully with id = " + id);
	}

	public List<Expence_Entity> retrieveByCategory(String category) {
		return expenceRepository.findByCategory(category);
	}
	
}
