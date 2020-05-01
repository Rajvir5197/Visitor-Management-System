package com.vms.project.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CO_VISITOR_DETAILS")
public class CoVisitorDetails {
	
	@Id
	@Column (name = "co_visitor_id")
	@GeneratedValue
	private int coVisitorId;
	
	@Column (name = "co_visitor_name")
	@NotNull
	private String coVisitorName;
	
	@Column (name = "co_visitor_contact")
	@NotNull
	private long coVisitorContact;
	
	@Column (name = "co_visitor_email")
	@NotNull
	private String coVisitorEmail;
	
	@Column (name = "sec_check_in")
	private boolean secCheckin;
	
	@Column (name = "sec_check_out")
	private boolean seccheckout;
	
	@OneToOne
	@JoinColumn (name = "visitor_id")
	private VisitorInfo visitor;
	
	@OneToMany(mappedBy = "visitor",cascade = CascadeType.REMOVE)
	private Set<AssetDetails> assets;
	
	@Column (name = "created_by")
	private int createdBy;
	
	@Column (name = "created_date")
	private Date createdDate;
	
	@Column (name = "created_time")
	private Time createdTime;

	public int getCoVisitorId() {
		return coVisitorId;
	}

	public void setCoVisitorId(int coVisitorId) {
		this.coVisitorId = coVisitorId;
	}

	public String getCoVisitorName() {
		return coVisitorName;
	}

	public void setCoVisitorName(String coVisitorName) {
		this.coVisitorName = coVisitorName;
	}

	public long getCoVisitorContact() {
		return coVisitorContact;
	}

	public void setCoVisitorContact(long coVisitorContact) {
		this.coVisitorContact = coVisitorContact;
	}

	public VisitorInfo getVisitor() {
		return visitor;
	}

	public void setVisitor(VisitorInfo visitor) {
		this.visitor = visitor;
	}

	/*
	 * public Set<AssetDetails> getAssets() { return assets; }
	 * 
	 * public void setAssets(Set<AssetDetails> assets) { this.assets = assets; }
	 */

	public boolean isSecCheckin() {
		return secCheckin;
	}

	public void setSecCheckin(boolean secCheckin) {
		this.secCheckin = secCheckin;
	}

	public boolean isSeccheckout() {
		return seccheckout;
	}

	public void setSeccheckout(boolean seccheckout) {
		this.seccheckout = seccheckout;
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

	public String getCoVisitorEmail() {
		return coVisitorEmail;
	}

	public void setCoVisitorEmail(String coVisitorEmail) {
		this.coVisitorEmail = coVisitorEmail;
	}
	
	
}
