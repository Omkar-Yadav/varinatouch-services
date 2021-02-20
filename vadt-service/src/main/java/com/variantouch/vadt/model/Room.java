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
@Table(name = "Room",
    uniqueConstraints = @UniqueConstraint(columnNames = {"roomId"}))
public class Room implements Serializable {

    private static final long serialVersionUID = 8334816928170220333L;

    @Id
    @Column(name = "roomId", nullable = false)
    private Long roomId;

    @Size(min = 2, max = 100, message = "roomName should have atleast 2 characters")
    @Column(name = "roomName", nullable = true)
    private String roomName;
    
    @Size(min = 2, max = 100, message = "roomType should have atleast 2 characters")
    @Column(name = "roomType", nullable = true)
    private String roomType;
}