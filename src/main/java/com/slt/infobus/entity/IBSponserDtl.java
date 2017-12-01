package com.slt.infobus.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_sponser_dtl")
public class IBSponserDtl {
	private int sponserId;
	private String name;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String contactPerson;
	private String phone;
	private String email;
	
	private Set<IBVideoDtl> videos;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sponser")
    public Set<IBVideoDtl> getVideos() { return videos; }
 	
	public void setVideos(Set<IBVideoDtl> videos) {
		this.videos = videos;
	}

	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SPNSR_ID", unique = true, nullable = false)	
	public int getSponserId() {
		return sponserId;
	}
	public void setSponserId(int sponserId) {
		this.sponserId = sponserId;
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
	@Column(name="CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
}
	