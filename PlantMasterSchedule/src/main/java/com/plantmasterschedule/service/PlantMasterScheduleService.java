package com.plantmasterschedule.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.plantmasterschedule.model.PlantMasterSchedule;

public interface PlantMasterScheduleService {

	List<PlantMasterSchedule> getPlantMasterSchedule();

	ResponseEntity<PlantMasterSchedule> addPlantMasterSchedule(@Valid PlantMasterSchedule plantmasterschedule);

}
