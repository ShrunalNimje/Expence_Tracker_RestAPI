package my.mood.ExpenceTracker.Expence_Tracker.DTO;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class ExpenceUpdateDTO {

	@Size(min = 3, message = "Title must be at least of 3 characters")
	private String title;
	
	@Min(value = 1, message = "Amount should be greater than 0")
	private Integer amount;
	
	@Size(min = 3, message = "Category must be at least of 3 characters")
	private String category;
	
	@Past(message = "Date shoule be past")
	private LocalDate date;
	
	public ExpenceUpdateDTO() {
		
	}
	
	public ExpenceUpdateDTO(String title, Integer amount, String category, LocalDate date) {
		super();
		this.title = title;
		this.amount = amount;
		this.category = category;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
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
}
