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
import com.vms.Sevices.EmployeeService;

@RestController
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	EmployeeService service;
	
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
}
