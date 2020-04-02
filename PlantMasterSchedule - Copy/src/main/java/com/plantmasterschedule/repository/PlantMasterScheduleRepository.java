package com.plantmasterschedule.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.plantmasterschedule.model.PlantMasterSchedule;


public interface PlantMasterScheduleRepository 
extends JpaRepository<PlantMasterSchedule, Long>{
	
	@Query(value = "SELECT * FROM plantmasterschedule WHERE date = ?1", nativeQuery = true)
	List<PlantMasterSchedule> findByDate(Date date);

	
}
