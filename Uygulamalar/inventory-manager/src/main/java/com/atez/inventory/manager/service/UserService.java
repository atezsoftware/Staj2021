package com.atez.inventory.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atez.inventory.manager.domain.KeycloakUser;
import com.atez.inventory.manager.entity.UserEntity;
import com.atez.inventory.manager.exception.CustomException;
import com.atez.inventory.manager.exception.ErrorCodes;
import com.atez.inventory.manager.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private KeyCloakService keyCloakService;
	
	
	public UserEntity findByUsernameFromKeycloak(String keyclaokId) {
		List<KeycloakUser> keycloakUser = keyCloakService.getUsers();
		KeycloakUser userKey = keycloakUser.stream().filter(user->user.getId().equals(keyclaokId)).findFirst().orElseThrow(()-> new CustomException(ErrorCodes.COULD_NOT_FOUND_USER));
		
		Optional<UserEntity> userOpt = userRepository.findByKeyCloakId(keyclaokId);
		
		UserEntity userEntity=userOpt.isPresent() ? userOpt.get() : new UserEntity();
		userEntity.setFirstname(userKey.getFirstName());
		userEntity.setLastname(userKey.getLastName());
		userEntity.setKeyCloakId(userKey.getId());
		return userRepository.save(userEntity);
		
	}
	

}
