package com.slt.infobus.util;

import java.sql.Time;

public class SlotDetails {

	private Time slotTime;
	private int minAvblSlots;
	private int minBalSlots;
	public Time getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(Time slotTime) {
		this.slotTime = slotTime;
	}
	public int getMinAvblSlots() {
		return minAvblSlots;
	}
	public void setMinAvblSlots(int minAvblSlots) {
		this.minAvblSlots = minAvblSlots;
	}
	public int getMinBalSlots() {
		return minBalSlots;
	}
	public void setMinBalSlots(int minBalSlots) {
		this.minBalSlots = minBalSlots;
	}
	
	
	
}
