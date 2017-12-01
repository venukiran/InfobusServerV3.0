package com.slt.infobus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_screen_metadata_dtl")
public class IBScreenMetadataDtl {
	private int scrnMetaId;
	private String deviceType;
	private String deviceNo;
	//scrn_id
	private IBScreenDtl screenDtl;	
	@OneToOne(optional=false,mappedBy="metadataDtl")
	public IBScreenDtl getScreenDtl() {
		return screenDtl;
	}
	public void setScreenDtl(IBScreenDtl screenDtl) {
		this.screenDtl = screenDtl;
	}
		
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SCRN_META_ID", unique = true, nullable = false)		
	public int getScrnMetaId() {
		return scrnMetaId;
	}
	
	public void setScrnMetaId(int scrnMetaId) {
		this.scrnMetaId = scrnMetaId;
	}
	@Column(name="DEVICE_TYPE")
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	@Column(name="DEVICE_NO")
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	
}
