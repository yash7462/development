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

import com.plantmasterschedule.model.PlantMasterSchedule;
import com.plantmasterschedule.repository.PlantMasterScheduleRepository;


@RestController
@RequestMapping("/plantmasterschedule")
public class PlantMasterScheduleController {
	@Autowired
	private PlantMasterScheduleRepository repo;
	
	@GetMapping("/")
	public List<PlantMasterSchedule> getPlantMasterSchedule() {
		return repo.findAll();
	}

	@PostMapping("/")
	public ResponseEntity<PlantMasterSchedule> addPlantMasterSchedule(@Valid @RequestBody PlantMasterSchedule plantmaster) {
		
		final PlantMasterSchedule updatedPlantMaster = repo.save(plantmaster);
		return ResponseEntity.ok(updatedPlantMaster);
	}

}
