package com.plantmasterschedule.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantmasterschedule.business.PlantMasterScheduleBusiness;
import com.plantmasterschedule.model.PlantMasterSchedule;
import com.plantmasterschedule.model.Slots;
import com.plantmasterschedule.repository.PlantMasterScheduleRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/plantmasterschedule")
public class PlantMasterScheduleController {
	@Autowired
	private PlantMasterScheduleBusiness plantmasterschedulebusiness;

	@Autowired
	private PlantMasterScheduleRepository repo;

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

	@GetMapping("/getslot")
	@ApiOperation(value = "", notes = "Get all PlantMasterSchedule")
	public List<String> getSlot(int hour, Slots slot) {
		LocalTime stt = slot.getSlotStartTime(); // getting start time is 06:30 <--(hh:mm)format
		int sthour = stt.getHour(); // getting hour and store in integer --> 06
		int stminute = stt.getMinute(); // getting minute and store in integer --> 30

		LocalTime ett = slot.getSlotEndTime(); // getting end time is 18:30 <--(hh:mm)format
		int ethour = ett.getHour(); // getting hour and store in integer --> 18
		int etminute = ett.getMinute(); // getting minute and store in integer --> 30

		// breakfast break time
		LocalTime breakfaststarttime = slot.getSlotBreakFastStartTime();// getting breakfast start time is 10:30
																		// <--(hh:mm)format
		int breakfaststarttimehour = breakfaststarttime.getHour(); // getting hour and store in integer --> 10
		int breakfaststarttimeminute = breakfaststarttime.getMinute(); // getting minute and store in integer --> 30
		LocalTime breakfastendtime = slot.getSlotBreakFastEndTime(); // getting end time is 11:30 <--(hh:mm)format
		int breakfastendtimehour = breakfastendtime.getHour(); // getting hour and store in integer --> 11
		int breakfastendtimeminute = breakfastendtime.getMinute(); // getting minute and store in integer --> 30

		// Snack break time
		LocalTime snackstarttime = slot.getSlotSnackStartTime();// getting breakfast start time is 14:30
																// <--(hh:mm)format
		int snackstarttimehour = snackstarttime.getHour(); // getting hour and store in integer --> 14
		int snackstarttimeminute = snackstarttime.getMinute(); // getting minute and store in integer --> 30
		LocalTime snackendtime = slot.getSlotSnackEndTime(); // getting end time is 15:30 <--(hh:mm)format
		int snackendtimehour = snackendtime.getHour(); // getting hour and store in integer --> 15
		int snackendtimeminute = snackendtime.getMinute(); // getting minute and store in integer --> 30

		List<String> al = new ArrayList<String>(); // creating list

		for (int i = sthour; i <= ethour; i++) {
			if (hour > 4) {
				break;
			}

			int fg = i + hour;

			if (hour == 4) {
				al.add(i + ":" + stminute + " to " + fg + ":" + etminute);
				break;
			}

			if (fg == ethour) {
				al.add(i + ":" + stminute + " to " + fg + ":" + etminute);
				i = ethour;
			} else if (fg == breakfaststarttimehour) {
				al.add(i + ":" + stminute + " to " + fg + ":" + etminute);

				i = breakfaststarttimehour;
			} else if (fg == snackstarttimehour) {
				al.add(i + ":" + stminute + " to " + fg + ":" + etminute);

				i = snackstarttimehour;
			} else {
				//al.add(i + ":" + stminute + " to " + fg + ":" + stminute);
				al.add(i + ":" + stminute + " to " + fg + ":" + stminute);
				al.add((i+1) + ":" + 00 + " to " + (fg+1) + ":" + 00);

			}

		}
System.out.println(al);
		return al;
	}

}
