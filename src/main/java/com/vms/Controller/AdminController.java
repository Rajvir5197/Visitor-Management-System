package com.vms.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.Model.MeetingStatus;
import com.vms.Model.Meetings;
import com.vms.Sevices.EmployeeService;
import com.vms.Sevices.MeetingsService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	MeetingsService meetingService;

	
	@RequestMapping(value = "/viewAllVisitsReport", method = RequestMethod.POST)
	@ResponseBody
	public List<MeetingStatus> viewAllVisitsReport() {

		return service.viewAllVisitsReport();
		
	}
	
	@RequestMapping(value = "/viewAllCancelVisitsReport", method = RequestMethod.POST)
	@ResponseBody
	public List<MeetingStatus> viewAllCancelVisitsReport() {

		return service.viewAllCancelVisitsReport();
		
	}
	
	@RequestMapping(value = "/getVisitsbetweenDates", method = RequestMethod.POST)
	@ResponseBody
	public List<MeetingStatus> getVisitsbetweenDates(@RequestBody Date startDate,@RequestBody Date endDate) {

		return service.getVisitsbetweenDates(startDate,endDate);
		
	}
	
	@GetMapping(value = "/downloadReport/reports.xlsx")
	@ResponseBody
	public ResponseEntity<InputStreamResource> downloadReport() {

		List<MeetingStatus> visits = service.viewAllVisitsReport();
	    ByteArrayInputStream in = null;
		try {
			in = service.customersToExcel(visits);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // return IOUtils.toByteArray(in);
	    
	    HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=reports.xlsx");
	    
	     return ResponseEntity
	                  .ok()
	                  .headers(headers)
	                  .body(new InputStreamResource(in));
		
	}
	
	@GetMapping(value = "/downloadReport/CancelVisiteports.xlsx")
	@ResponseBody
	public ResponseEntity<InputStreamResource> CancelVisiteports() {

		List<MeetingStatus> visits = service.viewAllCancelVisitsReport();
	    ByteArrayInputStream in = null;
		try {
			in = service.customersToExcel(visits);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    // return IOUtils.toByteArray(in);
	    
	    HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attachment; filename=reports.xlsx");
	    
	     return ResponseEntity
	                  .ok()
	                  .headers(headers)
	                  .body(new InputStreamResource(in));
		
	}
	
	@RequestMapping(value="/addMeeting", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addMeeting(@RequestBody Meetings meeting) {
		
		return meetingService.addMeeting(meeting);
	}
	
	@RequestMapping(value="/updateMeeting", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject updateMeeting(@RequestBody Meetings meeting) {
		
		return meetingService.updateMeeting(meeting);
	}
	
	@RequestMapping(value="/deleteMeeting", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteMeeting(@RequestBody Meetings meeting) {
		
		return meetingService.deleteMeeting(meeting);
	}
	
	@RequestMapping(value="/viewAllMeeting", method=RequestMethod.POST)
	@ResponseBody
	public List<Meetings> viewAllMeetings() {
		
		return meetingService.viewAllMeetings();
	}
}
