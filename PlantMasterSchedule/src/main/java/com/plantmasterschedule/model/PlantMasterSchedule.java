package com.plantmasterschedule.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plantmasterschedule")
@EntityListeners(AuditingEntityListener.class)
public class PlantMasterSchedule {
	/**
	 * id of this entity 
	 * its primary key
	 */
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long scheduleId;
	
	/**
	 * plantmasterId 
	 */
	@Column(name = "plantmasterId", nullable = false)
	private long plantmasterId;
	
	/**
	 * date in which plantmaster can add its schedule
	 */
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "date", nullable = false)
	private Date date;
	
	/**
	 * plantmaster is unavailable from
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name = "unavailfrom", nullable = false)
	private LocalTime unavailFrom;
	
	/**
	 * plantmaster is unavailability to
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name = "unavailto", nullable = false)
	private LocalTime unavailTo;
	
	/**
	 * timestamp where each record updated at a time
	 */
	@JsonIgnore
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedat", nullable = false)
	private Date updatedAt;

	public PlantMasterSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlantMasterSchedule(Long scheduleId, long plantmasterId, Date date, LocalTime unavailFrom,
			LocalTime unavailTo, Date updatedAt) {
		super();
		this.scheduleId = scheduleId;
		this.plantmasterId = plantmasterId;
		this.date = date;
		this.unavailFrom = unavailFrom;
		this.unavailTo = unavailTo;
		this.updatedAt = updatedAt;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public long getPlantmasterId() {
		return plantmasterId;
	}

	public void setPlantmasterId(long plantmasterId) {
		this.plantmasterId = plantmasterId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getUnavailFrom() {
		return unavailFrom;
	}

	public void setUnavailFrom(LocalTime unavailFrom) {
		this.unavailFrom = unavailFrom;
	}

	public LocalTime getUnavailTo() {
		return unavailTo;
	}

	public void setUnavailTo(LocalTime unavailTo) {
		this.unavailTo = unavailTo;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "PlantMasterSchedule [scheduleId=" + scheduleId + ", plantmasterId=" + plantmasterId + ", date=" + date
				+ ", unavailFrom=" + unavailFrom + ", unavailTo=" + unavailTo + ", updatedAt=" + updatedAt + "]";
	}

}
