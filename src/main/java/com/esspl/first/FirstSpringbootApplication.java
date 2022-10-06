package com.esspl.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.esspl.first.dao.AuthUserRepository;
import com.esspl.first.model.AuthUser;

@SpringBootApplication
@ComponentScan("com.esspl")
public class FirstSpringbootApplication implements CommandLineRunner {

	
	@Autowired
	private AuthUserRepository authUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringbootApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		 AuthUser authUser=new AuthUser();
		 authUser.setEmail("sonu@gmail.com");
		 authUser.setUsername("sonu");
		 authUser.setPassword(this.bcryptPasswordEncoder.encode("sonu"));
		 authUser.setRole("ROLE_ADMIN");
		 authUserRepository.save(authUser);
		 
		 
		
	}

}
