package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Expence_Entity {

	@Id
	@GeneratedValue
	private int id;
	
	private String title;
	
	private int amount;
	
	private String category;
	
	private LocalDate date;
	
	public Expence_Entity() {
		
	}
	
	public Expence_Entity(int id, String title, int amount, String category, LocalDate date) {
		super();
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.category = category;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Expence_Entity [id=" + id + ", title=" + title + ", amount=" + amount + ", category=" + category
				+ ", date=" + date + "]";
	}

}
