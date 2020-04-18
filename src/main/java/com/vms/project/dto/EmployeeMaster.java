package com.vms.project.dto;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_MASTER")
public class EmployeeMaster {

	@Id
	@Column (name = "emp_code")
	private int empCode;
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(unique = true) private PlantMaster plantCode;
	 */
	
	@Column (name = "grade_id")
	private int gradeId;
	
	@Column (name = "emp_name")
	private String empName;
	
	@Column (name = "emp_designation")
	private String empDesignation;
	
	@Column (name = "emp_role")
	private String empRole;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private DepartmentMaster empDept;
	
	@Column (name = "emp_mobile", unique = true)
	private long empMobile;
	
	@Column (name = "emp_pass")
	private String empPass;
	
	@Column (name = "profile_attachment")
	private Blob profileAttachment;
	
	@Column (name = "reg_by")
	private int regBy;
	
	@Column (name = "reg_date")
	private Date regDate;
	
	@Column (name = "reg_time")
	private Time regTime;

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

	public DepartmentMaster getEmpDept() {
		return empDept;
	}

	public void setEmpDept(DepartmentMaster empDept) {
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
