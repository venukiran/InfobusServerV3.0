package com.slt.infobus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_screen_dtl")
public class IBScreenDtl {
	private int screenId;
	private String name;
	private String orientation;
	private String resolution;
	private String browserType;
	private String version;
	//metadata
	private IBScreenMetadataDtl metadataDtl;
	@OneToOne(optional=false)
    @JoinColumn(name="SCRN_ID", unique=true, nullable=false, updatable=false)	
	public IBScreenMetadataDtl getMetadataDtl() {
		return metadataDtl;
	}

	public void setMetadataDtl(IBScreenMetadataDtl metadataDtl) {
		this.metadataDtl = metadataDtl;
	}
	//position
	private IBScreenPositionDtl positionDtl;
	@OneToOne(optional=false)
    @JoinColumn(name="SCRN_ID", unique=true, nullable=false, updatable=false)	
	public IBScreenPositionDtl getPositionDtl() {
		return positionDtl;
	}
	public void setPositionDtl(IBScreenPositionDtl positionDtl) {
		this.positionDtl = positionDtl;
	}

		
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SCRN_ID", unique = true, nullable = false)	
	public int getScreenId() {
		return screenId;
	}
	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="ORIENTATION")
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	@Column(name="RESOLUTION")
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	@Column(name="BROWSER_TYPE")
	public String getBrowserType() {
		return browserType;
	}
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}
	
	@Column(name="VERSION")
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
