package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class ExpenceService {
	
	public static List<Expence_Entity> expences = new ArrayList<>();
	public static int countId = 0;
	
	static {
		expences.add(new Expence_Entity(++countId, "Home", 10000, "Grocery", LocalDate.now().plusMonths(4)));
		expences.add(new Expence_Entity(++countId, "Home", 8000, "Electricity Bill", LocalDate.now().plusMonths(4)));
		expences.add(new Expence_Entity(++countId, "Home", 6000, "Gym", LocalDate.now().plusMonths(4)));
		expences.add(new Expence_Entity(++countId, "Home", 4000, "Others", LocalDate.now().plusMonths(4)));
	}
	
	// Retrieve all Expences
	public List<Expence_Entity> retrieveAll() {
		return expences;
	}
	
	// Retrieve a specific expence
	public Expence_Entity retrieveFromId(int id) {
		Predicate<? super Expence_Entity> predicate = expence -> expence.getId() == id;
		return expences.stream().filter(predicate).findFirst().orElseThrow(() -> new RuntimeException("Expence not found with id = " + id));
	}
	
	// Delete a specific expence
	public void deleteFromId(int id) {
		Predicate<? super Expence_Entity> predicate = expence -> expence.getId() == id;
		expences.removeIf(predicate);
	}
	
	// Add an expence
	public Expence_Entity addExpence(Expence_Entity entity) {
		entity.setId(++countId);
		expences.add(entity);
		return entity;
	}
	
	// Update an existing expence
	public Expence_Entity updateExpence(int id, Expence_Entity entity) {
		Predicate<? super Expence_Entity> predicate = expence -> expence.getId() == id;
		expences.removeIf(predicate);
		entity.setId(id);
		expences.add(entity);
		return entity;
	}
	
}
