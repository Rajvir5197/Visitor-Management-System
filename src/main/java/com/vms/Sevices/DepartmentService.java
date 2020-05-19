package com.vms.Sevices;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

		return repository.findAll();
	}

	public JSONObject addOrEditDepartment(Department department) {

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

	public JSONObject deleteDepartment(Department department) {

		JSONObject jsonObject = new JSONObject();

		List<Employee> employees = empRepository.findByEmpDept(department);
		for (Employee employee : employees) {
			employee.setEmpDept(null);
			empRepository.save(employee);
		}

		repository.deleteById(department.getDeptCode());

		jsonObject.put("data", "SUCCESS");
		return jsonObject;

	}

}
