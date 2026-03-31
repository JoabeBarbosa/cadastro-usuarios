package com.vsc.cadastro.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vsc.cadastro.user.DelRequestDTO;
import com.vsc.cadastro.user.User;
import com.vsc.cadastro.user.UserRepository;
import com.vsc.cadastro.user.UserRequestDTO;
import com.vsc.cadastro.user.UserResponseDTO;

import jakarta.validation.Valid;

//---
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
	//---
	@Autowired
	UserRepository userRepository;
	//---
	@GetMapping("/users")
	public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
		List<UserResponseDTO> usersList = userRepository.findAll()
													.stream()
													.map(UserResponseDTO::new)
													.toList();
		//---
		return ResponseEntity.ok(usersList);
	}
	//---
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody @Valid UserRequestDTO data){
		User newUser = new User(data);
		userRepository.save(newUser);
		//---
		return ResponseEntity.ok("New User created!");
	}
	//---
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable UUID userId){
		UUID Id = userId;
		userRepository.deleteById(Id);
		//---
		return ResponseEntity.noContent().build();
	}
//---
}
