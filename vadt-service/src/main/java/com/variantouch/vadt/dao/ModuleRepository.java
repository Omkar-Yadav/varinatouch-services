package com.variantouch.vadt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.Module;


@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

	@Query("SELECT e from Module e where e.id =:id ") // using @query
	public Module findByid(@Param("id") Long id);
}
