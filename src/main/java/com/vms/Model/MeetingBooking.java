package com.vms.Model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MEETING_BOOKING")
public class MeetingBooking {

	@Id
	@Column (name = "visit_no")
	@GeneratedValue
	private int visitNo;
	
	@Column (name = "emp_id")
	@NotNull
	private int empId;
	
	@Column (name = "emp_name")
	@NotNull
	private String empName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visitorId")
	private Visitor visitor;
	
	@Column (name = "meeting_type")
	@NotNull
	private String meetingType;
	
	@Column (name = "visit_date")
	@NotNull
	private Date visitDate;
	
	@Column (name = "visit_time")
	@NotNull
	private Time visitTime;
	
	@OneToOne
	@JoinColumn(name = "visit_location")
	@NotNull
	private Plant visitLocation;
	
	@Column (name = "remarks")
	private String remarks;
	
	@OneToOne
	@JoinColumn (name = "visit_department")
	private Department visitDepartment;
	
	@OneToOne(mappedBy = "meetingBooked")
	private MeetingStatus meetingStatus;

	public int getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(int visitNo) {
		this.visitNo = visitNo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Time getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Time visitTime) {
		this.visitTime = visitTime;
	}

	public Plant getVisitLocation() {
		return visitLocation;
	}

	public void setVisitLocation(Plant visitLocation) {
		this.visitLocation = visitLocation;
	}
	 
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getVisitDepartment() {
		return visitDepartment;
	}

	public void setVisitDepartment(Department visitDepartment) {
		this.visitDepartment = visitDepartment;
	}
	
	
	
}
