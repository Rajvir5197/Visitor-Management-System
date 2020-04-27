package com.vms.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.project.dao.ContactDao;
import com.vms.project.dao.DepartmentDao;
import com.vms.project.dao.MeetingDao;
import com.vms.project.dao.MeetingStatusDao;
import com.vms.project.dao.loginDao;
import com.vms.project.dao.plantDao;
import com.vms.project.dao.visitDao;
import com.vms.project.dto.ContactManagerDto;
import com.vms.project.dto.DepartmentMaster;
import com.vms.project.dto.EmployeeMaster;
import com.vms.project.dto.MeetingStatus;
import com.vms.project.dto.PlantMaster;
import com.vms.project.dto.VisitorInfo;

import net.minidev.json.JSONObject;

@RestController
public class LoginController {

	@Autowired
	loginDao repo;
	
	@Autowired
	plantDao plantRepo;
	
	@Autowired
	DepartmentDao deptRepo;
	
	@Autowired
	ContactDao contactRepo;
	
	@Autowired
	visitDao visitRepo;
	
	@Autowired
	MeetingDao bookMeetingRepo;
	
	@Autowired
	MeetingStatusDao meetingStatusRepo;
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject doLogin(@RequestBody EmployeeMaster employee) {
		
		JSONObject jsonObject = new JSONObject();
		Optional<EmployeeMaster> l = repo.findByEmpMobile(employee.getEmpMobile());
		if(l.isPresent()) {
			if(l.get().getEmpPass().equals(employee.getEmpPass())) {
				jsonObject.put("data", "SUCCESS");
				jsonObject.put("empDetails", l.get());
			}else {
				jsonObject.put("data", "FAIL");
			}
		}else {
			jsonObject.put("data", "FAIL");
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value="/viewAllPlant", method=RequestMethod.POST)
	@ResponseBody
	public List<PlantMaster> viewAllPlant() {
		
		List<PlantMaster> allPlants = plantRepo.findAll();
		
		return allPlants;
	}
	
	@RequestMapping(value="/addNewPlant", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewPlant(@RequestBody PlantMaster plant) {
		
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//plant.setRegBy(1421661);
		plant.setRegDate(Date.valueOf(LocalDate.now()));
		plant.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		PlantMaster plantSaved = plantRepo.save(plant);
		if(null != plantSaved) {
			jsonObject.put("data", "SUCCESS");
		}else {
			jsonObject.put("data", "FAIL");
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value="/editPlant", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject editPlant(@RequestBody PlantMaster plant) {
		
		//plant.setRegBy(1421661);
		plant.setRegDate(Date.valueOf(LocalDate.now()));
		plant.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		PlantMaster plantSaved = plantRepo.save(plant);
		if(null != plantSaved) {
			jsonObject.put("data", "SUCCESS");
		}else {
			jsonObject.put("data", "FAIL");
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value="/deletePlant", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deletePlant(@RequestBody PlantMaster plant) {
		
		//plant.setRegBy(1421661);
		plant.setRegDate(Date.valueOf(LocalDate.now()));
		plant.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		plantRepo.deleteById(plant.getPlantCode());
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
	
	@RequestMapping(value="/viewAllDept", method=RequestMethod.POST)
	@ResponseBody
	public List<DepartmentMaster> viewAllDept() {
		
		List<DepartmentMaster> allDepartments = deptRepo.findAll();
		
		return allDepartments;
	}
	
	@RequestMapping(value="/addNewOrEditDept", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewDept(@RequestBody DepartmentMaster department) {
		
		//department.setRegBy(1421661);
		department.setRegDate(Date.valueOf(LocalDate.now()));
		department.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		DepartmentMaster departmentSaved = deptRepo.save(department);
		if(null != departmentSaved) {
			jsonObject.put("data", "SUCCESS");
		}else {
			jsonObject.put("data", "FAIL");
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value="/deleteDept", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteDept(@RequestBody DepartmentMaster department) {
		
		//department.setRegBy(1421661);
		department.setRegDate(Date.valueOf(LocalDate.now()));
		department.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		deptRepo.deleteById(department.getDeptCode());
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
	
	@RequestMapping(value="/viewAllEmp", method=RequestMethod.POST)
	@ResponseBody
	public List<EmployeeMaster> viewAllEmp() {
		
		List<EmployeeMaster> allEmployees = repo.findAll();
		
		return allEmployees;
	}
	
	@RequestMapping(value="/addNewOrEditEmp", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewOrEditEmp(@RequestBody EmployeeMaster employee) {
		
		//employee.setRegBy(1421661);
		employee.setRegDate(Date.valueOf(LocalDate.now()));
		employee.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		EmployeeMaster employeeSaved = repo.save(employee);
		if(null != employeeSaved) {
			jsonObject.put("data", "SUCCESS");
		}else {
			jsonObject.put("data", "FAIL");
		}
		
		return jsonObject;
	}
	
	@RequestMapping(value="/deleteEmp", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteEmp(@RequestBody EmployeeMaster employee) {
		
		//employee.setRegBy(1421661);
		employee.setRegDate(Date.valueOf(LocalDate.now()));
		employee.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		repo.delete(employee);
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
	
	@RequestMapping(value="/viewAllContacts", method=RequestMethod.POST)
	@ResponseBody
	public List<ContactManagerDto> viewAllContacts(@RequestBody int loginId) {
		
		List<ContactManagerDto> allContacts = contactRepo.findByRegBy(loginId);
		
		return allContacts;
	}
	
	@RequestMapping(value="/addNewOrEditContact", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewOrEditContact(@RequestBody ContactManagerDto contact) {
		
		JSONObject jsonObject = new JSONObject();
		contact.setRegDate(Date.valueOf(LocalDate.now()));
		contact.setRegTime(Time.valueOf(LocalTime.now()));
		ContactManagerDto contanctSaved = contactRepo.save(contact);
		if(null != contanctSaved) {
			jsonObject.put("msg", "SUCCESS");
		}else {
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;
	}
	
	@RequestMapping(value="/deleteContact", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteContact(@RequestBody ContactManagerDto contact) {
		
		contact.setRegDate(Date.valueOf(LocalDate.now()));
		contact.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		contactRepo.delete(contact);
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
	
	@RequestMapping(value="/viewAllVisits", method=RequestMethod.POST)
	@ResponseBody
	public List<MeetingStatus> viewAllVisits() {
		
		List<MeetingStatus> allMeetings = meetingStatusRepo.findAll();
		return allMeetings;
	}
	
	@RequestMapping(value="/addNewVisit", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewVisit(@RequestBody MeetingStatus meeting) {
		
		JSONObject jsonObject = new JSONObject();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			meeting.getMeetingBooked().setCreatedAt(sdf.parse(sdf.format(timestamp)));
			meeting.setLastUpdatedAt(sdf.parse(sdf.format(timestamp)));
			meeting.setStatus("Booked");
			
			MeetingStatus meetingSaved = meetingStatusRepo.save(meeting);
			if(null != meetingSaved) {
				jsonObject.put("msg", "SUCCESS");
				jsonObject.put("meetingData", meetingSaved);
			}else {
				jsonObject.put("msg", "FAIL");
			}
		} catch (ParseException e) {
			e.printStackTrace();
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;
	
	}
	
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST)
	@ResponseBody
	public String sendMessage(@RequestBody MeetingStatus visitor) {
		try {
			// Construct data
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String apiKey = "apikey=" + "5YdXwI1maNE-PBsnyJDSrm6SJfIe9rSvsBXNQOqaIO";
			String message = "&message=" + "Your Meeting is schedule on "+ sdf.format(visitor.getMeetingBooked().getVisitDate()) +" "+visitor.getMeetingBooked().getVisitTime()
					+" with "+visitor.getMeetingBooked().getEmpId()+" at "+visitor.getMeetingBooked().getVisitLocation();
			String numbers = "&numbers=" + visitor.getMeetingBooked().getVisitor().getContactNumber();
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message; //+ sender;
			System.out.println("data: "+ data);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	@RequestMapping(value="/deleteVisit", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteContact(@RequestBody MeetingStatus meeting) {
		
		JSONObject jsonObject = new JSONObject();
		meetingStatusRepo.delete(meeting);
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
	
	
	  @RequestMapping(value="/empCheckIn", method=RequestMethod.POST)
	  @ResponseBody public JSONObject empCheckIn(@RequestBody MeetingStatus meeting) {
			
			JSONObject jsonObject = new JSONObject();
			try {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				meeting.setLastUpdatedAt(sdf.parse(sdf.format(timestamp)));
				meeting.setStatus("Checked In");
				meeting.setEmpCheckin(true);
				meeting.setEmpCheckinAt(sdf.parse(sdf.format(timestamp)));
				
				MeetingStatus meetingSaved = meetingStatusRepo.save(meeting);
				if(null != meetingSaved) {
					jsonObject.put("msg", "SUCCESS");
				}else {
					jsonObject.put("msg", "FAIL");
				}
			} catch (ParseException e) {
				e.printStackTrace();
				jsonObject.put("msg", "FAIL");
			}
			return jsonObject;
		
		}
	  
	  	@RequestMapping(value="/empCheckOut", method=RequestMethod.POST)
		@ResponseBody public JSONObject empCheckOut(@RequestBody MeetingStatus meeting) {
				
				JSONObject jsonObject = new JSONObject();
				try {
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					meeting.setLastUpdatedAt(sdf.parse(sdf.format(timestamp)));
					meeting.setStatus("Checked Out");
					meeting.setEmpCheckout(true);
					meeting.setEmpCheckoutAt(sdf.parse(sdf.format(timestamp)));
					
					MeetingStatus meetingSaved = meetingStatusRepo.save(meeting);
					if(null != meetingSaved) {
						jsonObject.put("msg", "SUCCESS");
					}else {
						jsonObject.put("msg", "FAIL");
					}
				} catch (ParseException e) {
					e.printStackTrace();
					jsonObject.put("msg", "FAIL");
				}
				return jsonObject;
			
			}
	 
	
}
