package com.slt.infobus.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slt.infobus.IBConfiguration;
import com.slt.infobus.common.IBPlayAudit;
import com.slt.infobus.entity.IBLocationDtl;
import com.slt.infobus.entity.IBMsgContentDtl;
import com.slt.infobus.entity.IBPlayReportDtl;
import com.slt.infobus.entity.IBServerDtl;
import com.slt.infobus.entity.IBSlotTrackerDtl;
import com.slt.infobus.entity.IBVideoSlotDtl;
import com.slt.infobus.repository.LocationDAO;
import com.slt.infobus.repository.MsgDAO;
import com.slt.infobus.repository.PlayReportDAO;
import com.slt.infobus.repository.ScreenDAO;
import com.slt.infobus.repository.ServerDAO;
import com.slt.infobus.repository.SlotTrackerDAO;
import com.slt.infobus.repository.VideoDAO;
import com.slt.infobus.repository.VideoSlotDAO;


@Component
public class InfoBusService {

	private final Logger logger = LoggerFactory.getLogger(InfoBusService.class);
	@Autowired
	IBConfiguration config;
	@Autowired
	LocationDAO locationDao;
	@Autowired
	VideoDAO videoDao;
	@Autowired
	VideoSlotDAO slotDao;
	@Autowired
	ScreenDAO screenDao;
	@Autowired
	MsgDAO msgDao;
	@Autowired
	ServerDAO serverDao;
	@Autowired
	PlayReportDAO playDao;
	@Autowired
	SlotTrackerDAO trackerDao;
	
	@SuppressWarnings("unchecked")
	
	private List<IBVideoSlotDtl> slotList = new ArrayList<IBVideoSlotDtl>(0);
	private List<IBMsgContentDtl> msgList = new ArrayList<IBMsgContentDtl>(0);
	private List<IBServerDtl> serverList = new ArrayList<IBServerDtl>(0);
	private List<IBSlotTrackerDtl> playTrackerList = new ArrayList<IBSlotTrackerDtl>(0);
	private IBLocationDtl location = null;
	private String dreamStepUrl = "";
	private String videosPath = "";	
	private Date startedDate = new Date();
	private String syncTime = null;
	
	
	@PostConstruct
	public void initializePlayList() throws Exception{
		logger.debug("Post Construct calling..");
		logger.debug("Get Video Data..");
		slotList = getVideoData();
		//playTrackerList = getVideoSlotData();
		logger.debug("Get Msg Data..");
		msgList = getScrollMsgData();
		logger.debug("Get Bus Data URL..");
		serverList = getBusDataURL();
		logger.debug("Get Video Path..");
		videosPath = getVideosPath();
		//startedDate = getSyncDate();
		location = getLocation();
	}
	
	public Date getStartedDate(){
		return startedDate;
	}
	
	private Date getSyncDate(){
		Date targetTime = null;
		System.out.println("Started Time::"+startedDate.toGMTString());
		System.out.println("Sync Time::"+config.getSyncTime());
		int min = config.getSyncTime();
		targetTime = DateUtils.addMinutes(startedDate,min); //add minute
		return targetTime;
	}
	
	public List<IBVideoSlotDtl> getVideoData(){
		List<IBVideoSlotDtl> slot=Collections.EMPTY_LIST;
		try{
		//System.out.println("location id::"+config.getLocId());	
		slot = slotDao.findAllByLocation(config.getLocId());
		int size = slot.size();
		System.out.println("slot size::"+size);
		}catch(Exception ex){
			logger.error("Error while getting Video Data::", ex);
			//ex.printStackTrace();
			//logger.debug("Exception in GetVideoData", ex);
		}
		return slot;
	}
	
	public List<IBSlotTrackerDtl> getVideoSlotData(){
		List<IBSlotTrackerDtl> slot=Collections.EMPTY_LIST;
		try{
	//	System.out.println("location id::"+config.getLocId());	
		slot = trackerDao.findAllByLocation(config.getLocId());
		int size = slot.size();
		System.out.println("slot size::"+size);
		}catch(Exception ex){
			logger.error("Error while getting Video Data::", ex);
			//ex.printStackTrace();
			//logger.debug("Exception in GetVideoData", ex);
		}
		return slot;
	}
	
	public IBLocationDtl getLocation(){
		IBLocationDtl loc=null;
		try{
		System.out.println("location id::"+config.getLocId());	
		loc = locationDao.getLocation(config.getLocId());
		}catch(Exception ex){
			logger.error("Error while getting Video Data::", ex);
			//ex.printStackTrace();
			//logger.debug("Exception in GetVideoData", ex);
		}
		return loc;
	}
	
	@SuppressWarnings("unchecked")
	public List<IBMsgContentDtl> getScrollMsgData(){
		List<IBMsgContentDtl> msg=Collections.EMPTY_LIST;
		try{
			msg = msgDao.findAllActive(config.getLocId());
			int size = msg.size();
			System.out.println("slot size::"+size);
		}catch(Exception ex){
			logger.error("Error while getting Scroll Msg Data::", ex);
			//ex.printStackTrace();
			logger.debug("Exception in getScrollMsgData", ex);
		}
		return msg;
	}
	
	@SuppressWarnings("unchecked")
	public List<IBServerDtl> getBusDataURL(){
		List<IBServerDtl> server=Collections.EMPTY_LIST;
		try{
			server = serverDao.findByLocation(config.getLocId());
			int size = server.size();
			//System.out.println("slot size::"+size);
		}catch(Exception ex){
			logger.error("Error while getting Bus Data URL::", ex);
			//ex.printStackTrace();
			logger.debug("Exception in getBusDataURL", ex);
		}
		return server;
	}
	
	public IBPlayReportDtl savePlayReport(IBPlayReportDtl report){
		return playDao.save(report);
	}
	
	public String getVideosPath(){
		return config.getVidPath();
	}

	public List<IBVideoSlotDtl> getSlotList() {
		return slotList;
	}

	public void setSlotList(List<IBVideoSlotDtl> slotList) {
		this.slotList = slotList;
	}

	public List<IBMsgContentDtl> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<IBMsgContentDtl> msgList) {
		this.msgList = msgList;
	}

	public List<IBServerDtl> getServerList() {
		return serverList;
	}

	public void setServerList(List<IBServerDtl> serverList) {
		this.serverList = serverList;
	}

	public String getDreamStepUrl() {
		return config.getDreamStepurl();
	}

	public void setDreamStepUrl(String dreamStepUrl) {
		this.dreamStepUrl = dreamStepUrl;
	}
		
}
