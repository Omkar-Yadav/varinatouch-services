package com.varinatouch.authenticationservice.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = { "emailId" }))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8334816928170220333L;

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Email
	@Column(name = "emailId", nullable = true)
	private String emailId;

	@Column(name = "token", nullable = true)
	private String token;

	@Column(name = "password", nullable = true)
	private String password;

	@Column(name = "role", nullable = true)
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
