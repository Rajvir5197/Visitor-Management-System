package com.vms.project.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PLANT_MASTER")
public class PlantMaster {

	@Id
	@Column (name = "plant_code")
	private int plantCode;
	
	@Column (name = "plant_name")
	@NotNull
	private String plantName;
	
	@Column (name = "plant_address")
	@NotNull
	private String plantAddress;
	
	@Column (name = "plant_city")
	@NotNull
	private String plantCity;
	
	@Column (name = "plant_pincode")
	@NotNull
	private int plantPincode;
	
	@Column (name = "plant_state")
	@NotNull
	private String plantState;
	
	@Column (name = "plant_country")
	@NotNull
	private String plantCountry;
	
	@Column (name = "plant_gst")
	@NotNull
	private String plantGst;
	
	@Column (name = "plant_pan")
	@NotNull
	private String plantPan;
	
	@Column (name = "plant_maplink")
	@NotNull
	private String plantMapLink;
	
	@Column (name = "plant_cin")
	@NotNull
	private String plantCin;
	
	@Column (name = "reg_by")
	private int regBy;
	
	@Column (name = "reg_date")
	private Date regDate;
	
	@Column (name = "reg_time")
	private Time regTime;
	
	@ManyToMany(mappedBy = "empPlantCode")
	@Column (name = "empPlantCode")
	private Set<EmployeeMaster> employeeMaster;

	public int getPlantCode() {
		return plantCode;
	}

	public void setPlantCode(int plantCode) {
		this.plantCode = plantCode;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getPlantAddress() {
		return plantAddress;
	}

	public void setPlantAddress(String plantAddress) {
		this.plantAddress = plantAddress;
	}

	public String getPlantCity() {
		return plantCity;
	}

	public void setPlantCity(String plantCity) {
		this.plantCity = plantCity;
	}

	public int getPlantPincode() {
		return plantPincode;
	}

	public void setPlantPincode(int plantPincode) {
		this.plantPincode = plantPincode;
	}

	public String getPlantState() {
		return plantState;
	}

	public void setPlantState(String plantState) {
		this.plantState = plantState;
	}

	public String getPlantCountry() {
		return plantCountry;
	}

	public void setPlantCountry(String plantCountry) {
		this.plantCountry = plantCountry;
	}

	public String getPlantGst() {
		return plantGst;
	}

	public void setPlantGst(String plantGst) {
		this.plantGst = plantGst;
	}

	public String getPlantPan() {
		return plantPan;
	}

	public void setPlantPan(String plantPan) {
		this.plantPan = plantPan;
	}

	public String getPlantMapLink() {
		return plantMapLink;
	}

	public void setPlantMapLink(String plantMapLink) {
		this.plantMapLink = plantMapLink;
	}

	public String getPlantCin() {
		return plantCin;
	}

	public void setPlantCin(String plantCin) {
		this.plantCin = plantCin;
	}

	public int getRegBy() {
		return regBy;
	}

	public void setRegBy(int regBy) {
		this.regBy = regBy;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Time getRegTime() {
		return regTime;
	}

	public void setRegTime(Time regTime) {
		this.regTime = regTime;
	}
	
}
