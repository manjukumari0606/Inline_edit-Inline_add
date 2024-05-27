package com.ex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class CompanyConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

		
		  // In memory security............... 
		 UserDetails admin = User.withUsername("Manju") 
				 .password(passwordEncoder.encode("Manju@123"))
				 .roles("ADMIN") .build();
		  
		  UserDetails user = User.withUsername("Swati")
				  .password(passwordEncoder.encode("Swati@123")) 
				  .roles("USER") .build();
		  
		  
		  	return new InMemoryUserDetailsManager(admin, user);
		 

	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		/*
		 * http.csrf().disable() .authorizeHttpRequests()
		 * .requestMatchers("/product/welcome","/user/new",
		 * "/product/authenticate").permitAll() .and()
		 * .authorizeHttpRequests().requestMatchers("/product/**")
		 * .authenticated().and().formLogin(); return http.build();
		 */

		
		  http.csrf().disable()
		  .authorizeHttpRequests().requestMatchers("/companyList","/company/{id}", "/company/save", "/company/delete/{id}").permitAll()
		  .and().authorizeHttpRequests().requestMatchers("/records").authenticated().and()
		  .formLogin().loginPage("/signin").loginProcessingUrl("/userLogin").
		  permitAll().and().logout().logoutSuccessUrl("/userlogout").permitAll();
		  
		  return http.build();
		 

		
	}
	
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Allow all origins, you might want to restrict this in production
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
