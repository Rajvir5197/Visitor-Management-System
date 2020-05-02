package com.vms.Sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.Model.Employee;
import com.vms.Repository.LoginRepository;

import net.minidev.json.JSONObject;
import java.util.Optional;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository repo;
	
	public JSONObject valiadateEmployee(Employee employee) {
		
		JSONObject jsonObject = new JSONObject();
		Optional<Employee> l = repo.findById(employee.getEmpCode());
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

}
