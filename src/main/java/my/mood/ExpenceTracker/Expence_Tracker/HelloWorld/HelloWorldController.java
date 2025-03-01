package my.mood.ExpenceTracker.Expence_Tracker.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World! This is my first small project.";
	}
}
