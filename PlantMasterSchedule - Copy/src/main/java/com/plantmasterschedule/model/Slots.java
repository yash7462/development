package com.plantmasterschedule.model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Slots {

	
	LocalTime slotStartTime = LocalTime.of(06, 30);
	LocalTime slotEndTime = LocalTime.of(18, 30);
	
	LocalTime slotBreakFastStartTime = LocalTime.of(10, 30);
	LocalTime slotBreakFastEndTime = LocalTime.of(11, 30);
	
	LocalTime slotSnackStartTime = LocalTime.of(14, 30);
	LocalTime slotSnackEndTime = LocalTime.of(15, 30);
	
	//Time ss = Time.;

	public Slots() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Slots(LocalTime slotStartTime, LocalTime slotEndTime, LocalTime slotBreakFastStartTime,
			LocalTime slotBreakFastEndTime, LocalTime slotSnackStartTime, LocalTime slotSnackEndTime) {
		super();
		this.slotStartTime = slotStartTime;
		this.slotEndTime = slotEndTime;
		this.slotBreakFastStartTime = slotBreakFastStartTime;
		this.slotBreakFastEndTime = slotBreakFastEndTime;
		this.slotSnackStartTime = slotSnackStartTime;
		this.slotSnackEndTime = slotSnackEndTime;
	}

	public LocalTime getSlotStartTime() {
		return slotStartTime;
	}

	public void setSlotStartTime(LocalTime slotStartTime) {
		this.slotStartTime = slotStartTime;
	}

	public LocalTime getSlotEndTime() {
		return slotEndTime;
	}

	public void setSlotEndTime(LocalTime slotEndTime) {
		this.slotEndTime = slotEndTime;
	}

	public LocalTime getSlotBreakFastStartTime() {
		return slotBreakFastStartTime;
	}

	public void setSlotBreakFastStartTime(LocalTime slotBreakFastStartTime) {
		this.slotBreakFastStartTime = slotBreakFastStartTime;
	}

	public LocalTime getSlotBreakFastEndTime() {
		return slotBreakFastEndTime;
	}

	public void setSlotBreakFastEndTime(LocalTime slotBreakFastEndTime) {
		this.slotBreakFastEndTime = slotBreakFastEndTime;
	}

	public LocalTime getSlotSnackStartTime() {
		return slotSnackStartTime;
	}

	public void setSlotSnackStartTime(LocalTime slotSnackStartTime) {
		this.slotSnackStartTime = slotSnackStartTime;
	}

	public LocalTime getSlotSnackEndTime() {
		return slotSnackEndTime;
	}

	public void setSlotSnackEndTime(LocalTime slotSnackEndTime) {
		this.slotSnackEndTime = slotSnackEndTime;
	}

	@Override
	public String toString() {
		return "Slots [slotStartTime=" + slotStartTime + ", slotEndTime=" + slotEndTime + ", slotBreakFastStartTime="
				+ slotBreakFastStartTime + ", slotBreakFastEndTime=" + slotBreakFastEndTime + ", slotSnackStartTime="
				+ slotSnackStartTime + ", slotSnackEndTime=" + slotSnackEndTime + "]";
	}

	
}
