package com.slt.infobus.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.slt.infobus.common.IBConstants;
import com.slt.infobus.common.IBPlayAudit;
import com.slt.infobus.entity.IBMsgContentDtl;
import com.slt.infobus.entity.IBPlayReportDtl;
import com.slt.infobus.entity.IBSlotTrackerDtl;
import com.slt.infobus.service.InfoBusService;

@CrossOrigin(origins = {"http://localhost", "http://localhost:80" }, maxAge = 4800, allowCredentials = "false", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
public class InfoBusController {
	 private final Logger logger = LoggerFactory.getLogger(InfoBusController.class);
	 @Autowired
	 InfoBusService service;
	 	 
	 @Autowired
	 IBPlayAudit playAudit;
	 
	 
	 @SuppressWarnings("unchecked")
	 @RequestMapping(value="/load/horizontal", method=RequestMethod.GET)
	 public @ResponseBody String loadDataToPlay(){
		 JSONObject respJson = new JSONObject();
		 respJson.put("videodata", processRequest(IBConstants.IB_HORIZONTAL));
		 logger.info("VideoData::"+respJson.toJSONString());
		 return respJson.toJSONString();
	 }
	
	 @SuppressWarnings("unchecked")
	 @RequestMapping(value="/load/vertical", method=RequestMethod.GET)
	 public @ResponseBody String loadVerticalDataToPlay(){  
		 JSONObject respJson = new JSONObject();
		 respJson.put("videodata", processRequest(IBConstants.IB_VERTICAL));
		 logger.info("VideoData::"+respJson.toJSONString());		 
		 return respJson.toJSONString();
	 }
	 
	 @RequestMapping(value="/logPlayAudit", method=RequestMethod.POST)
	 public @ResponseBody String logPlayAudit(@RequestBody String auditLog){
		 JSONParser parser = new JSONParser();
		 JSONObject respJson = new JSONObject();		 
		 if(auditLog!=null){
			//logger.info("auditLog::"+auditLog);
			//System.out.println(auditLog);
			playAudit.playAuditLog(auditLog.toString());
			String[] srr =  auditLog.split(",");
			IBPlayReportDtl report = new IBPlayReportDtl();
			// locationName+","+sponser_list[video_index]+","+video_list[video_index]+","+vidstTime+","+getCurrentTime()+",Play - "+param;
			try{
				int len = srr.length;
				report.setLocName(srr[0]);  //(String)auditLog.get("locationName"));
				report.setSponser(srr[1]); //(String)auditLog.get("sponser"));
				if(srr[2]!=null && srr[2].contains(".mp4")){
					report.setDescription("");
					report.setVideoName(srr[2]); //(String)auditLog.get("video"));
					report.setStTime(srr[3]); //(String)auditLog.get("stTime"));
					report.setEndTime(srr[4]); //(String)auditLog.get("endTime"));
					report.setStatus(srr[5]);//(String)auditLog.get("status"));	
				}else{
					report.setDescription(srr[2]);
					report.setVideoName(srr[3]); //(String)auditLog.get("video"));
					report.setStTime(srr[4]); //(String)auditLog.get("stTime"));
					report.setEndTime(srr[5]); //(String)auditLog.get("endTime"));
					report.setStatus(srr[6]);//(String)auditLog.get("status"));
				} 
				
				report.setPlayDate(new Date(Calendar.getInstance().getTimeInMillis()));
				service.savePlayReport(report);
			}catch(Exception ex){
				logger.info("Exception::",ex);
			}
			respJson.put("Status", "OK");
		 }
		 return respJson.toJSONString();
	 }
	 
	 @SuppressWarnings({ "unchecked", "deprecation" })	 
	 private JSONObject processRequest(String or){
		 JSONObject respJson = new JSONObject();
		 try{
			 String locationName = "NA";
			 if(service.getLocation()!=null){
				 locationName = service.getLocation().getName();
			 }
			 List<IBMsgContentDtl> msgData = service.getMsgList();
			 StringBuffer msgBuffer = new StringBuffer();
			 for (IBMsgContentDtl msgContent : msgData) {
				 msgBuffer.append(msgContent.getMsgContent());
				 msgBuffer.append("&nbsp &nbsp &nbsp");
			 }
			 // add location 
			 respJson.put("location", locationName);
			 respJson.put("url", service.getDreamStepUrl());
			 respJson.put("scrolltext",msgBuffer.toString());
			 
			//String time = service.getStartedDate().getHours()+":"+(service.getStartedDate().getMinutes())+":"+service.getStartedDate().getSeconds();
			 Calendar cal = Calendar.getInstance();
			 String time = "";
			 if(((cal.getTime()).getHours())>=1 && ((cal.getTime()).getHours())<=9){
				 time = ("0"+(cal.getTime()).getHours()) +":00:00";
			 }else{
				 time = ((cal.getTime()).getHours()) +":00:00";
			 }
			 //get video info
			 respJson.put("slot",preparePlayList(or, time));
			 respJson.put("slotTime",time);		     
			 logger.info("Server Started Time::"+ time);
			 
			 logger.info("response::"+respJson.toJSONString());
		 }catch(Exception ex){
			 logger.error("Error while loading data to play::",ex);
		 }
		 return respJson;
	 }
	 
	 @SuppressWarnings("unchecked")
		private TreeMap<String,JSONArray> preparePlayList(String or, String hr) throws Exception{
			 List<IBSlotTrackerDtl> videos = service.getPlayTrackerList(); //service.getVideoSlotData();
			 String videosPath= service.getVideosPath();
			 System.out.println("You are successfully connect and data ::"+videos.size()+", vidPath:"+videosPath);
			 logger.info("You are successfully connect and data ::"+videos.size()+", vidPath:"+videosPath);
			 JSONArray videoArray = new JSONArray();
			 JSONObject contentObj = null;
			 JSONObject vidObj = null;
			 TreeMap<String,JSONArray> slotMap = new TreeMap<String,JSONArray>();
			 for (IBSlotTrackerDtl slot : videos) {	
			  if(slot.getSlotTime().toString().equalsIgnoreCase(hr)){
				if((IBConstants.IB_VERTICAL.equalsIgnoreCase(or) && (slot.getVideoDtl().getOrientation().equalsIgnoreCase(IBConstants.IB_VERTICAL))) ||
						 ("V".equalsIgnoreCase(or) && (slot.getVideoDtl().getOrientation().equalsIgnoreCase("V")))){
					 if(slotMap.containsKey(slot.getSlotTime())){
						 videoArray = slotMap.get(slot.getSlotTime());
					 }else{
						 videoArray = new JSONArray();
					 }
					 for(int i=1; i<=slot.getRepeatsPerHr();i++){
						 vidObj = new JSONObject();
						 vidObj.put("video",videosPath+slot.getVideoDtl().getVideoName());
						 vidObj.put("sponser",slot.getVideoDtl().getSponser().getName());
						 vidObj.put("category",slot.getVideoDtl().getVideoCategory());
						 vidObj.put("descr",slot.getVideoDtl().getVideoDescr());
						 videoArray.add(vidObj);
					 }
					 slotMap.put(slot.getSlotTime().toString(), videoArray);
					 
				 }else if((IBConstants.IB_HORIZONTAL.equalsIgnoreCase(or) &&  (slot.getVideoDtl().getOrientation().equalsIgnoreCase(IBConstants.IB_HORIZONTAL))) ||
						 ("H".equalsIgnoreCase(or) &&  (slot.getVideoDtl().getOrientation().equalsIgnoreCase("H")))){
					 if(slotMap.containsKey(slot.getSlotTime().toString())){
						 videoArray =slotMap.get(slot.getSlotTime().toString());
					 }else{
						 videoArray = new JSONArray();
					 }
					 for(int i=1; i<=slot.getRepeatsPerHr();i++){
						 vidObj = new JSONObject();
						 vidObj.put("video",videosPath+slot.getVideoDtl().getVideoName());
						 vidObj.put("sponser",slot.getVideoDtl().getSponser().getName());
						 vidObj.put("category",slot.getVideoDtl().getVideoCategory());
						 vidObj.put("descr",slot.getVideoDtl().getVideoDescr());
						 videoArray.add(vidObj);
					 }
					 slotMap.put(slot.getSlotTime().toString(), videoArray);
				 }
			  }
			 }//for
			 return slotMap;
		}  
	 
	/*@SuppressWarnings("unchecked")
	private JSONObject getPlayList(String or){
		 Calendar cal = Calendar.getInstance();
		 @SuppressWarnings("deprecation")
		int time = ((cal.getTime()).getHours());
		 JSONObject json = new JSONObject();
		 if((IBConstants.IB_VERTICAL.equalsIgnoreCase(or)) || ("V".equalsIgnoreCase(or))){
			 if(service.getVerticalPlayList()!=null && (service.getVerticalPlayList().get(time+":00:00")!=null)){
				 json.put(time+":00:00", service.getVerticalPlayList().get(time+":00:00"));
			 }
		 }else{
			 if(service.getHorizontalPlayList()!=null && (service.getHorizontalPlayList().get(time+":00:00")!=null)){
				 json.put(time+":00:00", service.getHorizontalPlayList().get(time+":00:00"));
			 }
		 }
		 return json;
	 }*/
	 	
}
