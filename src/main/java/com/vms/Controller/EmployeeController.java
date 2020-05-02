package com.vms.Controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

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
	public JSONObject addNewOrEditEmp(@RequestParam("file") MultipartFile file,
			@RequestParam("empDetails") String jsonEmployee) {
		return service.addOrEditEmployee(jsonEmployee, file);
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


}
