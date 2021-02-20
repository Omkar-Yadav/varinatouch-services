package com.variantouch.vadt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	@Query("SELECT e from Contact e where e.emailId =:emailId ") // using @query
	public Contact findByEmailId(@Param("emailId") String emailId);
	
	
	@Query("SELECT e from Contact e where e.id =:id ") // using @query
	public Contact findByid(@Param("id") Long id);
}
