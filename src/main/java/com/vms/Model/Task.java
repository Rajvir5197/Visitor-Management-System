package com.vms.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASK_MASTERS")
public class Task {
	
	@Id
	@Column (name = "TASK_ID")
	@GeneratedValue
	private int task_id;
	
	@Column (name = "TASK_NAME")
	@NotNull
	private String taskName;
	
	@Column (name = "TASK_DESCRIPTION")
	@NotNull
	private String taskDescription;
	
	@Column (name = "TASK_STATUS")
	@NotNull
	private String taskStatus;
	
	@Column (name = "CREATED_BY")
	@NotNull
	private int createdBy;
	
	@Column (name = "CREATED_DATE")
	private Date createdDate;
	
	@Column (name = "CREATED_TIME")
	private Time createdTime;
	
	@Column (name = "COMPLETED_DATE")
	private Date completedDate;
	
	@Column (name = "COMPLETED_TIME")
	private Time completedTime;

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Time getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Time createdTime) {
		this.createdTime = createdTime;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Time getCompletedTime() {
		return completedTime;
	}

	public void setCompletedTime(Time completedTime) {
		this.completedTime = completedTime;
	}
	
	
}

