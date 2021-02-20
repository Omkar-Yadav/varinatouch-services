package com.variantouch.vadt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EnergyConsumption", uniqueConstraints = @UniqueConstraint(columnNames = {}))
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EnergyConsumption extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8334816928170220333L;

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "DateTime", nullable = true)
	private String dateTime;

	@Column(name = "power", nullable = true)
	private String power;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	User user;

}
