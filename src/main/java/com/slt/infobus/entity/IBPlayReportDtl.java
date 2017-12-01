package com.slt.infobus.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_play_report_dtl")
public class IBPlayReportDtl {
	private int playId;
	//private int locId;
	private String locName;
	private String videoName;
	private String stTime;
	private String endTime;
	private String status;
	private String description;
	private String sponser;
	private Date playDate;
	
	
	/*//loc_id
	private IBLocationDtl location;
	@ManyToOne
    @JoinColumn(name="LOC_ID", nullable=false)
    public IBLocationDtl getLocation() { return location; }
	
	public void setLocation(IBLocationDtl location) {
		this.location = location;
	}*/

	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PLAY_ID", unique = true, nullable = false)
	public int getPlayId() {
		return playId;
	}
	public void setPlayId(int playId) {
		this.playId = playId;
	}
	
	@Column(name="VIDEO_NAME")
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/*@Column(name="LOC_ID")	
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}*/
	
	@Column(name="LOCATION")
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	
	@Column(name="START_TIME")
	public String getStTime() {
		return stTime;
	}
	
	public void setStTime(String stTime) {
		this.stTime = stTime;
	}
	
	@Column(name="END_TIME")
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="DESCR")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="SPONSER")
	public String getSponser() {
		return sponser;
	}
	public void setSponser(String sponser) {
		this.sponser = sponser;
	}
	
	@Column(name="PLAY_DATE")
	public Date getPlayDate() {
		return playDate;
	}
	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}
	
	
	
}
