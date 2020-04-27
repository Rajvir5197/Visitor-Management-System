package com.vms.project.dto;

import java.sql.Date;
import java.sql.Time;
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
@Table(name = "DEPARTMENT_MASTER")
public class DepartmentMaster {

	@Id
	@Column (name = "dept_code")
	private int deptCode;
	
	@Column (name = "dept_name")
	@NotNull
	private String deptName;

	@Column (name = "dept_plant_code")
	@NotNull
	private int deptPlantCode;
	
	@Column (name = "reg_by")
	private int regBy;
	
	@Column (name = "reg_date")
	private Date regDate;
	
	@Column (name = "reg_time")
	private Time regTime;
	
	@OneToMany(mappedBy = "empDept")
	private Set<EmployeeMaster> employeeMaster;
	
	public int getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public int getDeptPlantCode() {
		return deptPlantCode;
	}

	public void setDeptPlantCode(int deptPlantCode) {
		this.deptPlantCode = deptPlantCode;
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
