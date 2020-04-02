package com.plantmasterschedule.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.plantmasterschedule.dao.PlantMasterScheduleDao;
import com.plantmasterschedule.model.PlantMasterSchedule;

@Service("PlantMasterScheduleService")
public class PlantMasterScheduleServiceImpl implements PlantMasterScheduleService {

	@Autowired
	private PlantMasterScheduleDao plantmasterscheduledao;

	@Override
	public List<PlantMasterSchedule> getPlantMasterSchedule() {
		return plantmasterscheduledao.getPlantMasterSchedule();
	}

	@Override
	public ResponseEntity<PlantMasterSchedule> addPlantMasterSchedule(@Valid PlantMasterSchedule plantmasterschedule) {
		return plantmasterscheduledao.addPlantMasterSchedule(plantmasterschedule);
	}

}
