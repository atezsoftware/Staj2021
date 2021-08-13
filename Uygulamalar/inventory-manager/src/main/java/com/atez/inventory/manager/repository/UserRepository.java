package com.atez.inventory.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atez.inventory.manager.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	//named query
	Optional<UserEntity> findByKeyCloakId(String username);

}
