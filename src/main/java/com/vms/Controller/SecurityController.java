package com.vms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vms.Model.Asset;
import com.vms.Model.CoVisitor;
import com.vms.Model.MeetingStatus;
import com.vms.Sevices.SecurityService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/Security")
public class SecurityController {

	@Autowired
	SecurityService service;

	@RequestMapping(value = "/addCoVisitor", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addCoVisitor(@RequestBody CoVisitor visitor) {

		return service.addCoVisitor(visitor);
	}

	@RequestMapping(value = "/viewAllCoVisitor", method = RequestMethod.POST)
	@ResponseBody
	public List<CoVisitor> viewAllCoVisitor(@RequestBody MeetingStatus meeting) {

		return service.viewAllCoVisitor(meeting);
	}

	@RequestMapping(value = "/getAllAsset", method = RequestMethod.POST)
	@ResponseBody
	public List<Asset> getAllAsset(@RequestBody CoVisitor coVisitor) {

		return service.getAllAsset(coVisitor);
	}

	@RequestMapping(value = "/addCoVisitorAsset", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addCoVisitorAsset(@RequestBody Asset asset) {

		return service.addCoVisitorAsset(asset);

	}
	
	@RequestMapping(value = "/securityCheckin", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject securityCheckin(@RequestBody MeetingStatus meeting) {

		return service.securityCheckin(meeting);

	}

}
