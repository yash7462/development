package com.plantmasterschedule.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantmasterschedule.business.PlantMasterScheduleBusiness;
import com.plantmasterschedule.model.PlantMasterSchedule;
import com.plantmasterschedule.repository.PlantMasterScheduleRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/plantmasterschedule")
public class PlantMasterScheduleController {
	@Autowired
	private PlantMasterScheduleBusiness plantmasterschedulebusiness;

	/**
	 * to find all schedule info of all plantmaster
	 * 
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value = "", notes = "Get all PlantMasterSchedule")
	public List<PlantMasterSchedule> getPlantMasterSchedule() {
		return plantmasterschedulebusiness.getPlantMasterSchedule();
		// return repo.findAll();
	}

	/**
	 * plant master can add his schedule using this
	 * 
	 * @param plantmaster
	 * @return
	 */
	@PostMapping("/")
	@ApiOperation(value = "", notes = "PlantMaster can Add it's schedule here")
	public ResponseEntity<PlantMasterSchedule> addPlantMasterSchedule(
			@Valid @RequestBody PlantMasterSchedule plantmasterschedule) {
		return plantmasterschedulebusiness.addPlantMasterSchedule(plantmasterschedule);
		// final PlantMasterSchedule updatedPlantMaster = repo.save(plantmaster);
		// return ResponseEntity.ok(updatedPlantMaster);
	}

}
