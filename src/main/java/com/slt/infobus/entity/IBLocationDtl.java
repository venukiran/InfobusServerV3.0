package com.slt.infobus.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_location_dtl")
public class IBLocationDtl {
	private int locationId;
	private String name;
	private String address1;
	private String address2;
	private String cityName;
	private String district;
	private String state;
	private String pincode;
	private String contactPerson;
	private String phone;
	private String email;
	
	private Set<IBPlatformDtl> platforms =new HashSet<IBPlatformDtl>(0);
	@OneToMany(cascade=CascadeType.ALL, mappedBy="location")
    public Set<IBPlatformDtl> getPlatforms() { return platforms; }
	
	public void setPlatforms(Set<IBPlatformDtl> platforms) {
		this.platforms = platforms;
	}

	private Set<IBMsgContentDtl> msges =new HashSet<IBMsgContentDtl>(0);
	@OneToMany(cascade=CascadeType.ALL, mappedBy="location")
    public Set<IBMsgContentDtl> getMsges() { return msges; }
	
	public void setMsges(Set<IBMsgContentDtl> msges) {
		this.msges = msges;
	}
	
/*	private IBServerDtl server;
	@OneToOne(optional=false)
	@OneToMany(cascade=CascadeType.ALL, mappedBy="location")
    
	@JoinColumn(name="LOC_ID", unique=true, nullable=false, updatable=false)	
	public IBServerDtl getServer() { return server; }
	
	public void setServer(IBServerDtl server) {
		this.server = server;
	}
*/
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOC_ID", unique = true, nullable = false)
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="ADDRESS1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name="ADDRESS2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name="CITY_NAME")
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@Column(name="DISTRICT")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	@Column(name="STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="PINCODE")
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Column(name="CONTACT_PERSON")
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	@Column(name="PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "IBLocationDtl [locationId=" + locationId + ", name=" + name + ", address1=" + address1 + ", address2="
				+ address2 + ", cityName=" + cityName + ", district=" + district + ", state=" + state + ", pincode="
				+ pincode + ", contactPerson=" + contactPerson + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
}
