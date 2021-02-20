package com.variantouch.vadt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.UserDevices;

@Repository
public interface UserDevicesRepository extends JpaRepository<UserDevices, Long> {

	@Query(value = "select u FROM UserDevices u WHERE u.userId = ?1")
	// SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)
	List<UserDevices> findDevicesByUserId(Long userId);

}
