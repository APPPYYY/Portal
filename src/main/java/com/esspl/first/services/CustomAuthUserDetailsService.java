package com.esspl.first.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.esspl.first.dao.AuthUserRepository;
import com.esspl.first.model.AuthUser;
import com.esspl.first.model.customAuthUserDetails;

@Service
public class CustomAuthUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthUserRepository authUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		AuthUser authUser=authUserRepository.findByUsername(username);
		
		if(authUser==null) {
			throw new UsernameNotFoundException("Invalid User !!!!"+username);
		}
		
		return new customAuthUserDetails(authUser);
	}

}
