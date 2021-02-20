package com.variantouch.vadt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "User", uniqueConstraints = @UniqueConstraint(columnNames = {"emailId"}))
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

	@OneToMany( cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "user")
	//@JoinColumn(name = "fk_uid", referencedColumnName = "id" ,nullable = false)
	private Set<Contact> contacts ;

    @OneToMany( cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "user")
  //  @JoinColumn(name = "fk_uid", referencedColumnName = "id",nullable = false)
	private Set<EnergyConsumption>  energyConsumptions;
	 

	public Long getId() {
		return id;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;

	//	return contacts;
	}

	public Set<EnergyConsumption> getEnergyConsumptions() {
		return energyConsumptions;
	}

	public void setEnergyConsumptions(Set<EnergyConsumption> energyConsumptions) {
		this.energyConsumptions = energyConsumptions;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
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

	@OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
 //   @JoinColumn(name = "fk_uid", referencedColumnName = "id",nullable = false)
	private Set<Payment> payments;
	 
	/*
	 * @OneToMany(fetch = FetchType.LAZY) private Set<DevicesInfo> devicesInfo;
	 */

}
