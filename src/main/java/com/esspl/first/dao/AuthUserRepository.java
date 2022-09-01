package com.esspl.first.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esspl.first.model.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, String> {

	public AuthUser findByUsername(String username);

}
