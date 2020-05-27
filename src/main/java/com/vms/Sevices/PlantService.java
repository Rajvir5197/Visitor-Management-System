package com.vms.Sevices;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.Model.Department;
import com.vms.Model.Employee;
import com.vms.Model.Plant;
import com.vms.Repository.DepartmentRepository;
import com.vms.Repository.EmployeeRepository;
import com.vms.Repository.PlantRepository;

import net.minidev.json.JSONObject;

@Service
public class PlantService {
	
	@Autowired
	PlantRepository repository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Plant> allPlant() {
		
		return repository.findByActive(true);
	}
	
	public JSONObject addPlant(Plant plant) {
		
		JSONObject jsonObject = new JSONObject();
		if(isExists(plant)) {
			jsonObject.put("data", "Exist");
			return jsonObject;
		}
		
		plant.setRegDate(Date.valueOf(LocalDate.now()));
		plant.setRegTime(Time.valueOf(LocalTime.now()));
		plant.setActive(true);
		
		Plant plantSaved = repository.save(plant);
		
		if(null != plantSaved) {
			jsonObject.put("data", "SUCCESS");
		}else {
			jsonObject.put("data", "FAIL");
		}
		
		return jsonObject;
	}
	
	public boolean isExists(Plant plant) {
		Optional<Plant> l = repository.findById(plant.getPlantCode());
		if(l.isPresent()) {
			return true;
		}
			return false;
	}
	
	public JSONObject editPlant(Plant plant) {
		
		JSONObject jsonObject = new JSONObject();
		plant.setRegDate(Date.valueOf(LocalDate.now()));
		plant.setRegTime(Time.valueOf(LocalTime.now()));
		
		Plant plantSaved = repository.save(plant);
		
		if(null != plantSaved) {
			jsonObject.put("data", "SUCCESS");
		}else {
			jsonObject.put("data", "FAIL");
		}
		
		return jsonObject;
	}
	
	public JSONObject deletePlant(Plant plant) {
		
		System.out.println("Start of deletePlant method");
		JSONObject jsonObject = new JSONObject();
		
		List<Employee> employees = employeeRepository.findAll();
		System.out.println("after fetching employees ");
		List<Employee> sortedEmployee = new ArrayList<Employee>();
		for(Employee employee: employees) {
			employee.getEmpPlantCode().stream().forEach((plan) -> {
				System.out.println("plant:"+plan.getPlantCode());
				if(plan.getPlantCode()== plant.getPlantCode()) {
					sortedEmployee.add(employee);
				}
			});
		}
		
		for (Employee employee : sortedEmployee) {
			Set<Plant> plantE= employee.getEmpPlantCode();
			Set<Plant> plantF = new HashSet<Plant>();
			
			plantE.stream().forEach((plantp) -> {
				if(plantp.getPlantCode() != plant.getPlantCode()) {
					plantF.add(plantp);
				}
			});
			Optional<Employee> e = employeeRepository.findById(employee.getEmpCode());
			e.get().setEmpPlantCode(plantF);
			employeeRepository.save(e.get());
			
		}
		
		List<Department> allDepartments = departmentRepository.findAll();
		List<Department> sortedDepartment = new ArrayList<Department>();
		for(Department department : allDepartments) {
			department.getDeptPlantCode().stream().forEach((plan) -> {
				if(plan.getPlantCode()== plant.getPlantCode()) {
					sortedDepartment.add(department);
				}
			});
		}
		
		for (Department department : sortedDepartment) {
			Set<Plant> plantE= department.getDeptPlantCode();
			Set<Plant> plantF = new HashSet<Plant>();
			
			plantE.stream().forEach((plantp) -> {
				if(plantp.getPlantCode() != plant.getPlantCode()) {
					plantF.add(plantp);
				}
			});
			Optional<Department> e = departmentRepository.findById(department.getDeptCode());
			e.get().setDeptPlantCode(plantF);
			departmentRepository.save(e.get());
			
		}
		
		plant.setActive(false);
		//repository.deleteById(plant.getPlantCode());
		repository.save(plant);
		
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
		
	}
	
	public long getAllPlantCount() {
		
		return repository.count();		
	}
	

}
