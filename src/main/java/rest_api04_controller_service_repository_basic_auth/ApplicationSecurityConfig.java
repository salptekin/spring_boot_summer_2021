package rest_api04_controller_service_repository_basic_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
			authorizeRequests().
			antMatchers("/", "index", "/css/*", "js/*").permitAll().
			anyRequest().
			authenticated().
			and().
			httpBasic();//Basic-Authentication: Uses username and password for every request
	}
	
	private final PasswordEncoder passwordEncoder;	
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		UserDetails student = User.
								builder().
								username("techproed").
								password(passwordEncoder.encode("password123")).
								roles("STUDENT").
								build(); 
		
		return new InMemoryUserDetailsManager(student);

	}
	
	

}
