package com.SpringBootCrud.SpringbootWebCurdemployee.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class DemoSecurityConfig {
	
//	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		
//		UserDetails jhon=User.builder()
//				.username("jhon")
//				.password("{noop}test123")
//				.roles("EMPLOYEE").build();
//		
//		UserDetails marry=User.builder()
//				.username("marry")
//				.password("{noop}test123")
//				.roles("EMPLOYEE","MANAGER").build();
//		
//		UserDetails piter=User.builder()
//				.username("piter")
//				.password("{noop}test123")
//				.roles("EMPLOYEE","MANAGER","ADMIN").build();
//		
//		return new InMemoryUserDetailsManager(jhon,marry,piter);
//		
//	}
	
	
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager jdbcUserdetailsManager=new JdbcUserDetailsManager(dataSource);
		
		// Define quary to retrieve a user by username
		
		jdbcUserdetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
		
		// Define quary to retrieve the authorities/role by username
		
		jdbcUserdetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
		
		
		return jdbcUserdetailsManager;
	}
	
	
	
	// set role wise security
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer->
		
		configurer
				.requestMatchers(HttpMethod.GET,"/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST,"/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT,"/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN")

				);
		// use Http basic authentication
		
		http.httpBasic(Customizer.withDefaults());
		
		// disable csfr
		
		http.csrf(csfr->csfr.disable());
		
		return http.build();
	}


}
