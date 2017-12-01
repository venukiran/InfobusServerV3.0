package com.slt.infobus.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class SlotBookings {
	
	private int videoId; //VIDEO_ID,
	private int locId; //LOC_ID,
	private Date slotDate; //SLOT_DATE, 
	private Time slotTime; //SLOT_TIME, 
	private BigDecimal sumBkdSlots;//SUM(BKD_SLOTS), 
	private BigDecimal sumRepats;//SUM(REPEATS_PER_HR)
	public Time getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(Time slotTime) {
		this.slotTime = slotTime;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public Date getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(Date slotDate) {
		this.slotDate = slotDate;
	}
	public BigDecimal getSumBkdSlots() {
		return sumBkdSlots;
	}
	public void setSumBkdSlots(BigDecimal sumBkdSlots) {
		this.sumBkdSlots = sumBkdSlots;
	}
	public BigDecimal getSumRepats() {
		return sumRepats;
	}
	public void setSumRepats(BigDecimal sumRepats) {
		this.sumRepats = sumRepats;
	}
}
