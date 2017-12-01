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
@Table(name="ib_server_dtl")
public class IBServerDtl {
	private int serverId;
	private String ipAddress;
	private String hostName;
	private String dreamstepUrl;
	private String osType;
	private String osVersion;
	private int locationId;
	//loc_id
	/*private IBLocationDtl location;
	@OneToOne(optional=false, mappedBy="server")	
	public IBLocationDtl getLocation(){return location;}
	
	public void setLocation(IBLocationDtl location) {
		this.location = location;
	}*/
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SERVER_ID", unique = true, nullable = false)
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	@Column(name="IP_ADDRESS")
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	@Column(name="HOST_NAME")
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	@Column(name="DREAMSTEP_URL")
	public String getDreamstepUrl() {
		return dreamstepUrl;
	}
	public void setDreamstepUrl(String dreamstepUrl) {
		this.dreamstepUrl = dreamstepUrl;
	}
	@Column(name="OS_TYPE")
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	@Column(name="OS_VERSION")
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	@Column(name="LOC_ID")
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}	
	
}
	