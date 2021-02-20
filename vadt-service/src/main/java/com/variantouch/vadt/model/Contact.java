package com.variantouch.vadt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity

@Table(name = "Contacts", uniqueConstraints = @UniqueConstraint(columnNames = { "emailId", "phoneNumber" }))
public class Contact extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8334816928170220333L;

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Size(min = 2, max = 100, message = "Display Name should have atleast 2 characters")
	@Column(name = "displayName", nullable = true)
	private String displayName;

	@Size(min = 2, max = 100, message = "First name should have atleast 2 characters")
	@Column(name = "firstName", nullable = true)
	private String firstName;

	@Column(name = "lastName", nullable = true)
	private String lastName;

	@Email
	@Column(name = "emailId", nullable = true)
	private String emailId;

	@Column(name = "phoneNumber", nullable = true)
	private String phoneNumber;

	@Column(name = "avatarUrl", nullable = true)
	private String avatarUrl;

	@Column(name = "Address", nullable = true)
	private String address;

	@Column(name = "city", nullable = true)
	private String city;

	@Column(name = "zipcode", nullable = true)
	private String zipcode;

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	User user;

	public Contact() {

	}

	public Contact(String displayName, String firstName, String lastName, String emailId, String imAddress,
			String phoneNumber, String vmrNumber, String avatarUrl) {
		super();
		this.displayName = displayName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.avatarUrl = avatarUrl;
	}

	public Contact(long id, String displayName, String firstName, String lastName, String emailId, String imAddress,
			String phoneNumber, String vmrNumber, String avatarUrl) {
		this.displayName = displayName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.avatarUrl = avatarUrl;
	}

	@Override
	public String toString() {
		return "Contact [displayName=" + displayName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", imAddress=" + "imaddress" + ", phoneNumber=" + phoneNumber
				+ ", vmrNumber=" + "vmrNumber" + ", avatarUrl=" + avatarUrl + ", getId()=" + getId()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + "]";
	}

	public Contact(Long id,
			@Size(min = 2, max = 100, message = "Display Name should have atleast 2 characters") String displayName,
			@Size(min = 2, max = 100, message = "First name should have atleast 2 characters") String firstName,
			String lastName, @Email String emailId, String phoneNumber, String avatarUrl, String address, String city,
			String zipcode, User user) {
		super();
		this.id = id;
		this.displayName = displayName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.avatarUrl = avatarUrl;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.user = user;
	}

}
