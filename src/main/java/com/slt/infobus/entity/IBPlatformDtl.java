package com.slt.infobus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_platform_dtl")
public class IBPlatformDtl {
	private int platformId;
	private int number;
	private String name;
	//scrn_pos_id
	private IBScreenPositionDtl screenPosition;
	@OneToOne(optional=false, mappedBy="platform")	
	public IBScreenPositionDtl getScreenPosition(){return screenPosition;}
	
	//loc_id
	private IBLocationDtl location;
	@ManyToOne
    @JoinColumn(name="LOC_ID", nullable=false)
    public IBLocationDtl getLocation() { return location; }
	
	public void setScreenPosition(IBScreenPositionDtl screenPosition) {
		this.screenPosition = screenPosition;
	}

	public void setLocation(IBLocationDtl location) {
		this.location = location;
	}

	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PLTFM_ID", unique = true, nullable = false)
	public int getPlatformId() {
		return platformId;
	}
	
	public void setPlatformId(int platformId) {
		this.platformId = platformId;
	}
	@Column(name="NUMBER")
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
