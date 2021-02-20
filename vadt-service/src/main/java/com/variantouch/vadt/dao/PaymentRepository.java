package com.variantouch.vadt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@Query("SELECT e from Payment e where e.id =:id ") // using @query
	public Payment findByid(@Param("id") Long id);
}
