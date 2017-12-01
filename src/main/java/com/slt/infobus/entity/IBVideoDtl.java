package com.slt.infobus.entity;

import java.sql.Time;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_video_dtl")
public class IBVideoDtl {
	private int videoId;
	private String videoName;
	private String videoDescr;	
	//private Time videoDuration;
	private String videoCategory; //FULL or LBAND or RBAND or STRIP or BUG or BANNER 
	private String playTime;
	private String videoFormat;
	private Date uploadedDate;
	private String fileSize;
	private String status;
	private Date validFrom;
	private Date validTo;
	private String modifyName;
	private String orientation;
	
	//spnrr_id
	private IBSponserDtl sponser;
	@ManyToOne
    @JoinColumn(name="SPNSR_ID", nullable=false)
	public IBSponserDtl getSponser(){ return sponser;}
	
	public void setSponser(IBSponserDtl sponser) {
		this.sponser = sponser;
	}

	/*private Set<IBVideoSlotDtl> slotDtl = new HashSet<IBVideoSlotDtl>(0);
	@OneToMany(cascade=CascadeType.ALL, mappedBy="videoDtl")    
	public Set<IBVideoSlotDtl> getSlotDtl() {
		return slotDtl;
	}
	public void setSlotDtl(Set<IBVideoSlotDtl> slotDtl) {
		this.slotDtl = slotDtl;
	}*/
	
	private Set<IBSlotTrackerDtl> slotTrackerDtl = new HashSet<IBSlotTrackerDtl>(0);
	@OneToMany(cascade=CascadeType.ALL, mappedBy="videoDtl")    
	public Set<IBSlotTrackerDtl> getSlotTrackerDtl() {
		return slotTrackerDtl;
	}
	public void setSlotTrackerDtl(Set<IBSlotTrackerDtl> slotDtl) {
		this.slotTrackerDtl = slotDtl;
	}
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VID_ID", unique = true, nullable = false)
	public int getVideoId() {
		return videoId;
	}
	
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	@Column(name="VIDEO_NAME")
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	@Column(name="PLAY_TIME")
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	@Column(name="VIDEO_FORMAT")
	public String getVideoFormat() {
		return videoFormat;
	}
	public void setVideoFormat(String videoFormat) {
		this.videoFormat = videoFormat;
	}
	@Column(name="UPLOADED_DATE")
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	@Column(name="FILE_SIZE")
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="VALID_FROM")
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	@Column(name="VALID_TO")
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	@Column(name="MODIFIED_NAME")
	public String getModifyName() {
		return modifyName;
	}
	public void setModifyName(String modifyName) {
		this.modifyName = modifyName;
	}	
	@Column(name="ORIENTATION")
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	@Column(name="VIDEO_DESCR")
	public String getVideoDescr() {
		return videoDescr;
	}

	public void setVideoDescr(String videoDescr) {
		this.videoDescr = videoDescr;
	}
	/*@Column(name="VIDEO_DURATION")
	public Time getVideoDuration() {
		return videoDuration;
	}

	public void setVideoDuration(Time videoDuration) {
		this.videoDuration = videoDuration;
	}
*/	
	@Column(name="VIDEO_CATEGORY")
	public String getVideoCategory() {
		return videoCategory;
	}

	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}
	
}
