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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

@Entity
@Table(name = "plantmasterschedule")
@EntityListeners(AuditingEntityListener.class)
public class PlantMasterSchedule {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long scheduleid;

	@Column(name = "plantmasterId", nullable = false)
	private long plantmasterId;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "date", nullable = false)
	private Date date;

	//@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name = "unavailfrom", nullable = false)
	private LocalTime unavailfrom;

	//@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name = "unavailto", nullable = false)
	private LocalTime unavailto;

	@JsonIgnore
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, timezone ="IST")
	@Column(name = "updatedat", nullable = false)
	private Date updatedat;

	public PlantMasterSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlantMasterSchedule(Long scheduleid, long plantmasterId, Date date, LocalTime unavailfrom, LocalTime unavailto,
			Date updatedat) {
		super();
		this.scheduleid = scheduleid;
		this.plantmasterId = plantmasterId;
		this.date = date;
		this.unavailfrom = unavailfrom;
		this.unavailto = unavailto;
		this.updatedat = updatedat;
	}

	public Long getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(Long scheduleid) {
		this.scheduleid = scheduleid;
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

	public LocalTime getUnavailfrom() {
		return unavailfrom;
	}

	public void setUnavailfrom(LocalTime unavailfrom) {
		this.unavailfrom = unavailfrom;
	}

	public LocalTime getUnavailto() {
		return unavailto;
	}

	public void setUnavailto(LocalTime unavailto) {
		this.unavailto = unavailto;
	}

	public Date getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	@Override
	public String toString() {
		return "PlantMasterSchedule [scheduleid=" + scheduleid + ", plantmasterId=" + plantmasterId + ", date=" + date
				+ ", unavailfrom=" + unavailfrom + ", unavailto=" + unavailto + ", updatedat=" + updatedat + "]";
	}
	
	

}
