package ch.zli3.ksh18a.crm.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	// @Autowired doesn't work here
	private UserDetailsService userDetailsService;
	private BCryptPasswordEncoder passwordEncoder;
	
	public WebSecurityConfiguration(
			BCryptPasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService
	) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}
			
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().and().cors().disable()
		.authorizeRequests()
			.antMatchers("/res/v1/**").permitAll()
			.anyRequest().authenticated()
		.and()
			.httpBasic()
		.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			;
	}

	
}
