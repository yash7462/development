package com.plantmasterschedule.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.plantmasterschedule.model.PlantMasterSchedule;
import com.plantmasterschedule.repository.PlantMasterScheduleRepository;
@Component
@Qualifier("PlantMasterScheduleDao")
public class PlantMasterScheduleDaoImpl implements PlantMasterScheduleDao {

	@Autowired
	private PlantMasterScheduleRepository plantmasterschedulerepository;

	@Override
	public List<PlantMasterSchedule> getPlantMasterSchedule() {
		return plantmasterschedulerepository.findAll();
	}

	@Override
	public ResponseEntity<PlantMasterSchedule> addPlantMasterSchedule(@Valid @RequestBody PlantMasterSchedule plantmaster) {
		final PlantMasterSchedule updatedPlantMaster = plantmasterschedulerepository.save(plantmaster);
		return ResponseEntity.ok(updatedPlantMaster);
	}
}
