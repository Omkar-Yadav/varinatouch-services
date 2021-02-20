package com.variantouch.vadt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Device",
    uniqueConstraints = @UniqueConstraint(columnNames = {"deviceId"}))
public class Device implements Serializable {

    private static final long serialVersionUID = 8334816928170220333L;

    @Id
    @Column(name = "deviceId")
    private Long deviceId;

    @Size(min = 0, max = 100)
    @Column(name = "defaultvalue", nullable = true)
    private String defaultvalue;
    
    @Size(min = 2, max = 100)
    @Column(name = "deviceName", nullable = true)
    private String deviceName;
    
    @Size(min = 2, max = 100)
    @Column(name = "deviceType", nullable = true)
    private String deviceType;
    
    @Column(name = "devicestatus", nullable = true)
    private Boolean devicestatus;
    
    @Column(name = "devicekind", nullable = true)
    private char devicekind;

  
}
