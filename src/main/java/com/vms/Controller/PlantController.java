package com.vms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.Model.Plant;
import com.vms.Sevices.PlantService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/Plant")
public class PlantController {
	
	@Autowired
	PlantService service;
	
	@RequestMapping(value="/viewAllPlant", method=RequestMethod.POST)
	@ResponseBody
	public List<Plant> viewAllPlant() {
		
		return service.allPlant();
	}
	
	@RequestMapping(value="/addNewPlant", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addNewPlant(@RequestBody Plant plant) {
		
		return service.addPlant(plant);
	}
	
	@RequestMapping(value="/editPlant", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject editPlant(@RequestBody Plant plant) {
		
		return service.editPlant(plant);
	}
	
	@RequestMapping(value="/deletePlant", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deletePlant(@RequestBody Plant plant) {
		
		return service.deletePlant(plant);
	}
	
	
}
