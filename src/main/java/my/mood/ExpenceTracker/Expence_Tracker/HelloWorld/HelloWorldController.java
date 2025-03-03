package my.mood.ExpenceTracker.Expence_Tracker.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	// To ensure everything working properly
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World! This is my first small project.";
	}
}
