package com.vms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.Model.Department;
import com.vms.Sevices.DepartmentService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@RequestMapping(value="/viewAllDept", method=RequestMethod.POST)
	@ResponseBody
	public List<Department> viewAllDepartment() {
		
		return service.allDepartment();
	}
	
	@RequestMapping(value="/addNewOrEditDept", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewOrEditDep(@RequestBody Department department) {
		
		return service.addOrEditDepartment(department);
	}
	
	
	@RequestMapping(value="/deleteDept", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deletePlant(@RequestBody Department department) {
		
		return service.deleteDepartment(department);
	}

}
