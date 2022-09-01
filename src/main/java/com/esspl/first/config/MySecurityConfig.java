package com.esspl.first.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.esspl.first.services.CustomAuthUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig  {

	@Autowired
	private CustomAuthUserDetailsService customAuthUserService;

	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * 
	 * .csrf().disable() .authorizeRequests() .antMatchers("/signin").permitAll()
	 * .antMatchers("/register").hasRole("ADMIN")
	 * .antMatchers(HttpMethod.GET,"/ex/**").hasRole("MANAGER")
	 * .anyRequest().authenticated().and().formLogin().loginPage("/signin").
	 * loginProcessingUrl("/dologin")
	 * .defaultSuccessUrl("/").and().logout().logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout")) .logoutSuccessUrl("/signin"); }
	 */
	
	@Bean
	protected DaoAuthenticationProvider daoAuthenticationProvider() throws Exception {

		/*
		 * auth.inMemoryAuthentication().withUser("subham").password(
		 * "{bcrypt}$2y$10$g0R1C7LNhcxs49cc.WHmmeLldflTuYTf8MtrSWC0aPNVelcZJ/JDW").roles
		 * ("ADMIN")
		 * .and().withUser("ronnie").password("{noop}ronnie").roles("USER").and().
		 * withUser("shibani").password("{noop}shibani").roles("MANAGER");
		 */
		
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();

		provider.setUserDetailsService(this.customAuthUserService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;

	}
	

	

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http

				.csrf().disable()
				.authorizeRequests().antMatchers("/signin").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers(HttpMethod.GET, "/ex/**").hasRole("MANAGER")
				.anyRequest().authenticated()
				.and().formLogin().loginPage("/signin").loginProcessingUrl("/dologin").defaultSuccessUrl("/")
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		DefaultSecurityFilterChain defaultSecurityFilterChain=http.build();
		
		return defaultSecurityFilterChain;
	}
	
	@Bean
	protected BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	
	@Bean
	protected AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
	
	
	
	
	
	
	

	

}
