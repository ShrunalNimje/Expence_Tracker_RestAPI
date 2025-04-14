package my.mood.ExpenceTracker.Expence_Tracker.Security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 1) To authenticate each and every request which will come into system
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/v3/api-docs/**", 
	                    "/swagger-ui/**", 
	                    "/swagger-ui.html").permitAll()
				.anyRequest().authenticated()
				);
		
		// 2) If request is not authenticated, a pop up is shown
		http.httpBasic(withDefaults());
		
		// 3) CSRF is disabled
		http.csrf(csrf-> csrf.disable());
		
		return http.build();
	}
	
	// Core interface which loads user-specific data
	@Bean
	public UserDetailsService userDetailsService() {
	    UserDetails user = User.withUsername("Shrunal")
	            .password(passwordEncoder().encode("dummy")) 
	            .roles("USER")
	            .build();

	    return new InMemoryUserDetailsManager(user);
	}
	
	// Service interface for encoding passwords
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
    }
	
}