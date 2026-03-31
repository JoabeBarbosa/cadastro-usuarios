package com.vsc.cadastro.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,UUID> {
	public Optional<User> findByUserName(String name);
}
