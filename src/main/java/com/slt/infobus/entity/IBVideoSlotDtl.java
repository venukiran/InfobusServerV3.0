package com.slt.infobus.entity;

import java.sql.Date;

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
@Table(name="ib_video_slot_dtl")
public class IBVideoSlotDtl {
	private int slotId;
	private Date startDate;
	private Date endDate;
	/*private Timestamp startTime;
	private Timestamp endTime;*/
	private int displayOrder;
	private int locationId;
	
	//vid_id
	private IBVideoDtl videoDtl;	
	@ManyToOne
    @JoinColumn(name="VID_ID", nullable=false)
	public IBVideoDtl getVideoDtl() {
		return videoDtl;
	}
	public void setVideoDtl(IBVideoDtl videoDtl) {
		this.videoDtl = videoDtl;
	}
	
	@Column(name="DISPLAY_ORDER")
	public int getDisplayOrder() {
		return displayOrder;
	}
	
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SLOT_ID", unique = true, nullable = false)
	public int getSlotId() {
		return slotId;
	}
	
	public void setSlotId(int slotId) {
		this.slotId = slotId;
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
	/*@Column(name="START_TIME")
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	@Column(name="END_TIME")
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}*/
	@Column(name="LOC_ID")
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}	
}
