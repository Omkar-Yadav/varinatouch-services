package com.variantouch.vadt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

	@Query("SELECT e from Device e where e.id =:id ") // using @query
	public com.variantouch.vadt.model.Device findByid(@Param("id") Long id);
}
