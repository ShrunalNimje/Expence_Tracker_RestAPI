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
		
		// 1) All requests should be authenticated
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		// 2) If request is not authenticated, a pop up is shown
		http.httpBasic(withDefaults());
		
		// 3) CSRF -> post, put
		http.csrf(csrf-> csrf.disable());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
	    UserDetails user = User.withUsername("Shrunal")
	            .password(passwordEncoder().encode("dummy")) // 🔥 Encode the password!
	            .roles("USER")
	            .build();

	    return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); 
    }
	
}