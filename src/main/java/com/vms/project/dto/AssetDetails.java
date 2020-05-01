package com.vms.project.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ASSET_DETAILS")
public class AssetDetails implements Serializable {

	@Id
	@Column (name = "asset_id")
	@GeneratedValue
	private int assetId;
	
	@Column (name = "asset_name")
	@NotNull
	private String assetName;
	
	@Column (name = "asset_count")
	@NotNull
	private int assetCount;
	
	@Column (name = "asset_status")
	private String assetStatus;
	
	@Column (name = "delivered_flag")
	private boolean deliveredFlag;
	
	@ManyToOne
	@JoinColumn(name = "co_visitor_id")
	private CoVisitorDetails visitor;
	
	
	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public int getAssetCount() {
		return assetCount;
	}

	public void setAssetCount(int assetCount) {
		this.assetCount = assetCount;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public boolean isDeliveredFlag() {
		return deliveredFlag;
	}

	public void setDeliveredFlag(boolean deliveredFlag) {
		this.deliveredFlag = deliveredFlag;
	}

	
	public CoVisitorDetails getVisitor() {
		return visitor;
	}

	public void setVisitor(CoVisitorDetails visitor) {
		this.visitor = visitor;
	}
	
	
	
	
}
