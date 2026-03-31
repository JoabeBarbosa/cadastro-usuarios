package com.vsc.cadastro.user;

import java.util.UUID;

//---
public record UserResponseDTO(UUID userId,
							  String userName,
							  Integer userAge,
							  String userEmail) {
	//---
	public UserResponseDTO(User user){
		this(user.getUserId(),user.getUserName(),user.getUserAge(),user.getUserEmail());
	}
//---
}
