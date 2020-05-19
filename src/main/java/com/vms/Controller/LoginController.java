package com.vms.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.Model.Employee;
import com.vms.Sevices.LoginService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/Login")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject doLogin(@RequestBody Employee employee) {
		return service.valiadateEmployee(employee);
	}

}
