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
@Table(name = "CONTACT_MANAGER")
public class ContactManager {

	@Id
	@Column (name = "contact_id")
	@GeneratedValue
	private int contactId;
	
	@Column (name = "salutation")
	@NotNull
	private String salutation;
	
	@Column (name = "first_name")
	@NotNull
	private String firstName;
	
	@Column (name = "middle_name")
	private String middleName;
	
	@Column (name = "last_name")
	@NotNull
	private String lastName;
	
	@Column (name = "designation")
	@NotNull
	private String designation;
	
	@Column (name = "gender")
	@NotNull
	private String gender;
	
	@Column (name = "company")
	@NotNull
	private String company;
	
	@Column (name = "mobile_numb")
	@NotNull
	private long mobileNumb;
	
	@Column (name = "email_id")
	@NotNull
	private String emailId;
	
	@Column (name = "reg_by")
	@NotNull
	private int regBy;
	
	@Column (name = "reg_date")
	private Date regDate;
	
	@Column (name = "reg_time")
	private Time regTime;

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public long getMobileNumb() {
		return mobileNumb;
	}

	public void setMobileNumb(long mobileNumb) {
		this.mobileNumb = mobileNumb;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
