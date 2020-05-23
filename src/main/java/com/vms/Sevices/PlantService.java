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
import com.vms.Model.Plant;
import com.vms.Repository.PlantRepository;

import net.minidev.json.JSONObject;

@Service
public class PlantService {
	
	@Autowired
	PlantRepository repository;
	
	public List<Plant> allPlant() {
		
		return repository.findAll();
	}
	
	public JSONObject addPlant(Plant plant) {
		
		JSONObject jsonObject = new JSONObject();
		if(isExists(plant)) {
			jsonObject.put("data", "Exist");
			return jsonObject;
		}
		
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
		
		JSONObject jsonObject = new JSONObject();
		
		repository.deleteById(plant.getPlantCode());
		
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
		
	}
	

}
