package com.esspl.first.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class customAuthUserDetails implements UserDetails {

	
	private AuthUser authUser;
	
	
	
	public customAuthUserDetails(AuthUser authUser) {
		super();
		this.authUser = authUser;
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		HashSet<SimpleGrantedAuthority>set=new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.authUser.getRole()));
		
		return set;
	}

	@Override
	public String getPassword() {
		
		return this.authUser.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.authUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
