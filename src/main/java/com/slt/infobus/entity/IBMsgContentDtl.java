package com.slt.infobus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ib_msg_content_dtl")
public class IBMsgContentDtl {
	private int msgId;
	private String msgContent;
	private String status;
	private String msgType;
	
	//loc_id
	private IBLocationDtl location;
	@ManyToOne
    @JoinColumn(name="LOC_ID", nullable=false)
    public IBLocationDtl getLocation() { return location; }
	
	public void setLocation(IBLocationDtl location) {
		this.location = location;
	}

	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MSG_ID", unique = true, nullable = false)
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	
	@Column(name="MSG_CONTENT")
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="MSG_TYPE")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
		
}
