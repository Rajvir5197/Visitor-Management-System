package com.vms.Sevices;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.Model.Department;
import com.vms.Model.Employee;
import com.vms.Repository.DepartmentRepository;
import com.vms.Repository.EmployeeRepository;

import net.minidev.json.JSONObject;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	@Autowired
	EmployeeRepository empRepository;

	public List<Department> allDepartment() {

		return repository.findByActive(true);
	}

	public JSONObject addDepartment(Department department) {

		JSONObject jsonObject = new JSONObject();
		if(isExists(department)) {
			jsonObject.put("data", "Exist");
			return jsonObject;
		}
		department.setRegDate(Date.valueOf(LocalDate.now()));
		department.setRegTime(Time.valueOf(LocalTime.now()));
		department.setActive(true);

		Department departmentSaved = repository.save(department);

		if (null != departmentSaved) {
			jsonObject.put("data", "SUCCESS");
		} else {
			jsonObject.put("data", "FAIL");
		}

		return jsonObject;
	}
	
	public boolean isExists(Department dept) {
		Optional<Department> l = repository.findById(dept.getDeptCode());
		if(l.isPresent()) {
			return true;
		}
			return false;
	}

	public JSONObject deleteDepartment(Department department) {

		JSONObject jsonObject = new JSONObject();

		List<Employee> employees = empRepository.findByEmpDept(department);
		for (Employee employee : employees) {
			employee.setEmpDept(null);
			empRepository.save(employee);
		}

		department.setActive(false);
		department.setDeptPlantCode(null);
		//repository.deleteById(department.getDeptCode());
		repository.save(department);
		
		jsonObject.put("data", "SUCCESS");
		return jsonObject;

	}

	public JSONObject EditDept(Department department) {

		JSONObject jsonObject = new JSONObject();
		department.setRegDate(Date.valueOf(LocalDate.now()));
		department.setRegTime(Time.valueOf(LocalTime.now()));

		Department departmentSaved = repository.save(department);

		if (null != departmentSaved) {
			jsonObject.put("data", "SUCCESS");
		} else {
			jsonObject.put("data", "FAIL");
		}

		return jsonObject;
	}

}
