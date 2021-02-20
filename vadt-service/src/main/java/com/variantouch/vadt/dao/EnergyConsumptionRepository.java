package com.variantouch.vadt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.EnergyConsumption;

@Repository
public interface EnergyConsumptionRepository extends JpaRepository<EnergyConsumption, Long> {

	@Query("SELECT e from EnergyConsumption e where e.id =:id ") // using @query
	public EnergyConsumption findByid(@Param("id") Long id);

}
