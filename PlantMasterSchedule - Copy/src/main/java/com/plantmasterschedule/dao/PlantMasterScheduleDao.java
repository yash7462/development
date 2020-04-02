package com.plantmasterschedule.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.plantmasterschedule.model.PlantMasterSchedule;

public interface PlantMasterScheduleDao {

	List<PlantMasterSchedule> getPlantMasterSchedule();

	ResponseEntity<PlantMasterSchedule> addPlantMasterSchedule(@Valid PlantMasterSchedule plantmasterschedule);

}
