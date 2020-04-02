package com.plantmasterschedule.business;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.plantmasterschedule.model.PlantMasterSchedule;
import com.plantmasterschedule.service.PlantMasterScheduleService;
@Component
public class PlantMasterScheduleBusiness {
	
	@Autowired
	private PlantMasterScheduleService plantmasterscheduleservice;

	public List<PlantMasterSchedule> getPlantMasterSchedule() {
		
		return plantmasterscheduleservice.getPlantMasterSchedule();
	}

	public ResponseEntity<PlantMasterSchedule> addPlantMasterSchedule(@Valid PlantMasterSchedule plantmasterschedule) {
		
		return plantmasterscheduleservice.addPlantMasterSchedule(plantmasterschedule);
	}

}
