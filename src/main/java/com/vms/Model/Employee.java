package com.vms.Model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "EMPLOYEE_MASTER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable {

	@Id
	@Column (name = "emp_code")
	private int empCode;

	@Column (name = "grade_id")
	@NotNull
	private int gradeId;
	
	@Column (name = "emp_name")
	@NotNull
	private String empName;
	
	@Column (name = "emp_designation")
	@NotNull
	private String empDesignation;
	
	@Column (name = "emp_role")
	@NotNull
	private String empRole;
	
	@ManyToOne
	@JoinColumn(name = "EMP_DEPT")
	@NotNull
	private Department empDept;
	
	@Column (name = "emp_mobile", unique = true)
	@NotNull
	private long empMobile;
	
	@Column (name = "emp_pass")
	@NotNull
	private String empPass;
	
	@Column (name = "profile_attachment")
	private Blob profileAttachment;
	
	@Column (name = "image")
	private byte[] image;
	
	@Column (name = "reg_by")
	private int regBy;
	
	@Column (name = "reg_date")
	private Date regDate;
	
	@Column (name = "reg_time")
	private Time regTime;
	
	@ManyToMany
	@JoinColumn(name = "EMP_PLANT")
	@NotNull
	private Set<Plant> empPlantCode;

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public Department getEmpDept() {
		return empDept;
	}

	public void setEmpDept(Department empDept) {
		this.empDept = empDept;
	}

	public long getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(long empMobile) {
		this.empMobile = empMobile;
	}
	
	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public Blob getProfileAttachment() {
		return profileAttachment;
	}

	public void setProfileAttachment(Blob profileAttachment) {
		this.profileAttachment = profileAttachment;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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
	
	public Set<Plant> getEmpPlantCode() {
		return empPlantCode;
	}

	public void setEmpPlantCode(Set<Plant> empPlantCode) {
		this.empPlantCode = empPlantCode;
	}
	
}