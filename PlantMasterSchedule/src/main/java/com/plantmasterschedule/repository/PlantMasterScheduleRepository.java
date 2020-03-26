package com.plantmasterschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plantmasterschedule.model.PlantMasterSchedule;


public interface PlantMasterScheduleRepository 
extends JpaRepository<PlantMasterSchedule, Long>{
	
}
