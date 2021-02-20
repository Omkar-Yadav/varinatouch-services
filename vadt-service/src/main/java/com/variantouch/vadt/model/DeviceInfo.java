package com.variantouch.vadt.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
@Data
@Entity
@Table(name = "DeviceInfo",
    uniqueConstraints = @UniqueConstraint(columnNames = {}))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/
public class DeviceInfo /*extends BaseEntity implements Serializable*/{

/*  private static final long serialVersionUID = 8334816928170220333L;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_device")
  private Device device;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_room")
  private Room room;*/

}
