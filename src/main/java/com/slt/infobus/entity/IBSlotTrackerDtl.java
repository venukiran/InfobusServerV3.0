package com.slt.infobus.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_slot_tracker_dtl")
public class IBSlotTrackerDtl {
	private int trackerId; //TRACKER_ID
	private int slotBookId;
	private Date slotDate;//SLOT_DATE
	private Time slotTime;//SLOT_TIME
	private int availableSlots;//AVBL_SLOTS
	private int bookedSlots; //BKD_SLOTS
	private int balanceSlots;//BAL_SLOTS
	private Time totPlayTimePerHr; //PLAY_TIME_PER_HR
	private int repeatsPerHr; //REPEATS_PER_HR
	private int locationId;
	private int videoId;
	
	//vid_id
	private IBVideoDtl videoDtl;	
	@ManyToOne
    @JoinColumn(name="VIDEO_ID", nullable=false)
	public IBVideoDtl getVideoDtl() {
		return videoDtl;
	}
	public void setVideoDtl(IBVideoDtl videoDtl) {
		this.videoDtl = videoDtl;
	}
		
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRACKER_ID", unique = true, nullable = false)
	public int getTrackerId() {
		return trackerId;
	}
	public void setTrackerId(int trackerId) {
		this.trackerId = trackerId;
	}

	@Column(name="SLOT_BK_ID")
	public int getSlotBookId() {
		return slotBookId;
	}
	public void setSlotBookId(int slotBookId) {
		this.slotBookId = slotBookId;
	}
	
	@Column(name="SLOT_DATE")	
	public Date getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}
	
	@Column(name="SLOT_TIME")
	public Time getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(Time slotTime) {
		this.slotTime = slotTime;
	}
	
	
	@Column(name="LOC_ID")
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	/*@Column(name="VIDEO_ID", nullable=false)
	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}*/
	
	@Column(name="AVBL_SLOTS", nullable=false)	
	public int getAvailableSlots() {
		return availableSlots;
	}
	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}
	
	@Column(name="BKD_SLOTS", nullable=false)	
	public int getBookedSlots() {
		return bookedSlots;
	}
	public void setBookedSlots(int bookedSlots) {
		this.bookedSlots = bookedSlots;
	}
	
	@Column(name="BAL_SLOTS", nullable=false)
	public int getBalanceSlots() {
		return balanceSlots;
	}
	public void setBalanceSlots(int balanceSlots) {
		this.balanceSlots = balanceSlots;
	}

	@Column(name="PLAY_TIME_PER_HR", nullable=false)	
	public Time getTotPlayTimePerHr() {
		return totPlayTimePerHr;
	}
	public void setTotPlayTimePerHr(Time totPlayTimePerHr) {
		this.totPlayTimePerHr = totPlayTimePerHr;
	}
	
	@Column(name="REPEATS_PER_HR", nullable=false)
	public int getRepeatsPerHr() {
		return repeatsPerHr;
	}
	public void setRepeatsPerHr(int repeatsPerHr) {
		this.repeatsPerHr = repeatsPerHr;
	}
	
}
