package com.variantouch.vadt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.variantouch.vadt.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


	@Query("SELECT e from Room e where e.id =:id ") // using @query
	public Room findByid(@Param("id") Long id);
}
