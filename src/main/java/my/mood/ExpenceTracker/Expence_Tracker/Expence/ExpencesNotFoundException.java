package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExpencesNotFoundException extends RuntimeException{

	public ExpencesNotFoundException(String message) {
		super(message);
	}
	
}
