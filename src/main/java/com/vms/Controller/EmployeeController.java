package com.vms.Controller;

import java.sql.Blob;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vms.Model.ContactManager;
import com.vms.Model.Department;
import com.vms.Model.Employee;
import com.vms.Model.MeetingStatus;
import com.vms.Model.Task;
import com.vms.Sevices.EmployeeService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/viewAllEmp", method = RequestMethod.POST)
	@ResponseBody
	public List<Employee> viewAllEmployee() {

		return service.allEmployee();
	}

	@RequestMapping(value = "/addNewOrEditEmp", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewEmp(@RequestParam("file") MultipartFile file,
			@RequestParam("empDetails") String jsonEmployee) {
		
		return service.addEmployee(jsonEmployee, file);
	}
	
	@RequestMapping(value = "/editNewOrEditEmp", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject editNewEmp(@RequestParam("file") MultipartFile file,
			@RequestParam("empDetails") String jsonEmployee) {
		return service.editEmployee(jsonEmployee, file);
	}
	
	@RequestMapping(value = "/addNewEmp", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewEmp(@RequestBody Employee employee) {
		return service.addNewEmp(employee);
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject changePassword(@RequestBody Employee employee) {
		return service.changePassword(employee);
	}
	
	@RequestMapping(value = "/editEmp", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject editEmp(@RequestBody Employee employee) {
		return service.EditNewEmp(employee);
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteEmployee(@RequestBody Employee employee) {

		return service.deleteEmployee(employee);
	}

	@RequestMapping(value = "/viewAllContacts", method = RequestMethod.POST)
	@ResponseBody
	public List<ContactManager> viewAllContacts(@RequestBody int loginId) {

		List<ContactManager> allContacts = service.viewAllContacts(loginId);

		return allContacts;
	}

	@RequestMapping(value = "/addNewOrEditContact", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewOrEditContact(@RequestBody ContactManager contact) {

		return service.addNewOrEditContact(contact);
	}

	@RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteContact(@RequestBody ContactManager contact) {

		return service.deleteContact(contact);
	}

	@RequestMapping(value = "/viewAllVisits", method = RequestMethod.POST)
	@ResponseBody
	public List<MeetingStatus> viewAllVisits(@RequestBody Employee employee) {

		if("Security".equalsIgnoreCase(employee.getEmpRole())) {
			return service.viewAllVisit();
		}else {
			return service.viewAllVisitOfEmployee(employee.getEmpCode());
		}
		
	}

	@RequestMapping(value = "/addNewVisit", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewVisit(@RequestBody MeetingStatus meeting) {

		return service.addNewVisit(meeting);

	}

	@RequestMapping(value = "/deleteVisit", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deletevisit(@RequestBody MeetingStatus meeting) {

		return service.deleteVisit(meeting);
	}

	@RequestMapping(value = "/empCheckIn", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject empCheckIn(@RequestBody MeetingStatus meeting) {

		return service.empCheckIn(meeting);

	}

	@RequestMapping(value = "/empCheckOut", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject empCheckOut(@RequestBody MeetingStatus meeting) {

		return service.empCheckOut(meeting);

	}
	
	@RequestMapping(value="/getEmpPlant", method=RequestMethod.POST)
	@ResponseBody
	public Employee getEmpPlant(@RequestBody Employee employee) {
		return service.getEmpPlant(employee);
	}
	
	@RequestMapping(value = "/cancelVisit", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject cancelVisit(@RequestBody MeetingStatus meeting) {

		return service.cancelVisit(meeting);
	}
	
	@RequestMapping(value = "/viewTask", method = RequestMethod.POST)
	@ResponseBody
	public List<Task> viewTask(@RequestBody int loginId) {

		return service.viewTask(loginId);
	}
	
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addTask(@RequestBody Task task) {

		return service.addTask(task);
	}
	
	@RequestMapping(value = "/completeTask", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject completeTask(@RequestBody Task task) {

		return service.completeTask(task);
	}
	@RequestMapping(value = "/TotalVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public int getTotalVisitCount(@RequestBody int loginId) {
		return service.getTotalVisitCount(loginId);
	}
	
	@RequestMapping(value = "/getAllVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public long getAllVisitCount(@RequestBody int loginId) {
		return service.getAllVisitCount();
	}
	
	@RequestMapping(value = "/getAllEmployeeCount", method = RequestMethod.POST)
	@ResponseBody
	public long getAllEmployeeCount(@RequestBody int loginId) {
		return service.getAllEmployeeCount();
	}

	@RequestMapping(value = "/TodaysVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public int getTodaysVisitCount(@RequestBody int loginId) {

		return service.getTodaysVisitCount(loginId);
	}

	@RequestMapping(value = "/CancelVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public int getCancelVisitCount(@RequestBody int loginId) {
		return service.getCancelVisitCount(loginId);
	}

	@RequestMapping(value = "/AttendedVisitCount", method = RequestMethod.POST)
	@ResponseBody
	public int getAttendedVisitCount(@RequestBody int loginId) {
		return service.getAttendedVisitCount(loginId);
	}
	
	@RequestMapping(value = "/GetLoggedInDetails", method = RequestMethod.POST)
	@ResponseBody
	public Employee getLoggedInDetails(@RequestBody int loginId) {
		return service.getLoggedInDetails(loginId);
	}
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject sendEmail(@RequestBody MeetingStatus meeting) {
		
		return service.sendEmail(meeting);
	}


}
