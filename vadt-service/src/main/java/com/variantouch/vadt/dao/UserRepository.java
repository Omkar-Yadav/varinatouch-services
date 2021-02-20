package com.variantouch.vadt.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT e from User e where e.emailId =:emailId ") // using @query
	public User findByEmailId(@Param("emailId") String emailId);

	@Query("SELECT e from User e where e.id =:id ") // using @query
	public User findByid(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "update User e set emailId = :emailId where e.id = :id ") // using @query
	public Integer updateUser(String emailId, Long id);

}
