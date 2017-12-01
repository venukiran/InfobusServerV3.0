package com.slt.infobus.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ib_slot_booking_dtl")
public class IBSlotBookingDtl {
	private int slotBookId;
	private Date startDate;
	private Date endDate;
	private Time startTime;
	private Time endTime;
	private int repeatsPerDay;//REPEATS_PER_DAY
	private Date bookedDate;//BOOKED_DATE
	private String locationId;
	private int videoId;
	
	//vid_id
/*	private IBVideoDtl videoDtl;	
	@ManyToOne
    @JoinColumn(name="VID_ID", nullable=false)
	public IBVideoDtl getVideoDtl() {
		return videoDtl;
	}
	public void setVideoDtl(IBVideoDtl videoDtl) {
		this.videoDtl = videoDtl;
	}
*/	
	
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SLOT_BK_ID", unique = true, nullable = false)
	
	public int getSlotBookId() {
		return slotBookId;
	}

	public void setSlotBookId(int slotBookId) {
		this.slotBookId = slotBookId;
	}

	
	@Column(name="START_DATE")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name="END_DATE")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(name="START_TIME")
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	@Column(name="END_TIME")
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	@Column(name="LOC_ID")
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Column(name="VIDEO_ID", nullable=false)
	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	@Column(name="REPEATS_PER_DAY", nullable=false)	
	public int getRepeatsPerDay() {
		return repeatsPerDay;
	}

	public void setRepeatsPerDay(int repeatsPerDay) {
		this.repeatsPerDay = repeatsPerDay;
	}

	@Column(name="BOOKED_DATE", nullable=false)	
	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}
	
}
