package com.vsc.cadastro.user;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//---
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "userId")
@Entity(name = "users")
@Table(name = "users")
public class User{
	//---
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	//--- write raw SQL to define a specific column's properties during the table creation (DDL generation)
	@Column(name = "user_id")
	private UUID userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_age")
	private Integer userAge;
	@Column(name = "user_email")
	private String userEmail;
	//---
	@Transient
	private static final long serialVersionUID = 1L;
	//---
	public User(UserRequestDTO user) {
		this.userName = user.userName();
		this.userAge = user.userAge();
		this.userEmail = user.userMail();
	}
	
}
