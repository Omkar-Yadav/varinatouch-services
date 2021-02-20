package com.variantouch.vadt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "EntityClass", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class EntityClass {

	@Id
	@Size(min = 1, max = 10, message = "Deviceid should have atleast 2 characters")
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, max = 100, message = "deviceName should have atleast 2 characters")
	@Column(name = "name", nullable = false)
	private String name;

	@Size(min = 2, max = 100, message = "description should have atleast 2 characters")
	@Column(name = "description", nullable = false)
	private String description;

	@Size(min = 2, max = 100, message = "password should have atleast 2 characters")
	@Column(name = "password", nullable = false)
	private String password;

	@Size(min = 2, max = 100, message = "deviceName should have atleast 2 characters")
	@Column(name = "passwordValidity", nullable = false)
	private Long passwordValidity;

}
