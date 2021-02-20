package com.variantouch.vadt.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Module",
    uniqueConstraints = @UniqueConstraint(columnNames = {"moduleId"}))
public class Module implements Serializable {

    private static final long serialVersionUID = 8334816928170220333L;

    @Id
    @Column(name = "moduleId", nullable = true)
    private Long moduleId;

    @Size(min = 2, max = 100, message = "moduleIp should have atleast 2 characters")
    @Column(name = "moduleIp", nullable = true)
    private String moduleIp;
    
  
}