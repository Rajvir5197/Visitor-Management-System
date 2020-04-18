package com.vms.project.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.project.dao.loginDao;
import com.vms.project.dao.plantDao;
import com.vms.project.dto.EmployeeMaster;
import com.vms.project.dto.PlantMaster;

import net.minidev.json.JSONObject;

@RestController
public class LoginController {

	@Autowired
	loginDao repo;
	
	@Autowired
	plantDao plantRepo;
	/*
	 * @Autowired SecurityContextHolder
	 */
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject doLogin(@RequestBody EmployeeMaster employee) {
		
		JSONObject jsonObject = new JSONObject();
		Optional<EmployeeMaster> l = repo.findByEmpMobile(employee.getEmpMobile());
		if(l.isPresent()) {
			if(l.get().getEmpPass().equals(employee.getEmpPass())) {
				jsonObject.put("data", "SUCCESS");
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
		plant.setRegBy(1421661);
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
		
		plant.setRegBy(1421661);
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
		
		plant.setRegBy(1421661);
		plant.setRegDate(Date.valueOf(LocalDate.now()));
		plant.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		System.out.println("in java");
		plantRepo.deleteById(plant.getPlantCode());
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
}
