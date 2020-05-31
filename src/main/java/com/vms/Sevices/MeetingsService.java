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
import com.vms.Model.Meetings;
import com.vms.Repository.MeetingMasterRepository;

import net.minidev.json.JSONObject;

@Service
public class MeetingsService {
	
	@Autowired
	MeetingMasterRepository repository;
	
	public JSONObject addMeeting(Meetings meeting) {
		
		JSONObject jsonObject = new JSONObject();
		if(isExist(meeting)) {
			jsonObject.put("data", "Exist");
			return jsonObject;
		}
		meeting.setRegDate(Date.valueOf(LocalDate.now()));
		meeting.setRegTime(Time.valueOf(LocalTime.now()));
		repository.save(meeting);
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
	
	public boolean isExist(Meetings meeting) {
		List<Meetings> allmeetings = repository.findAll();
		for(Meetings m : allmeetings) {
			if(m.getMeetingType().equalsIgnoreCase(meeting.getMeetingType())) {
				return true;
			}
		}
		return false; 
	}
	
	public JSONObject updateMeeting(Meetings meeting) {
		
		JSONObject jsonObject = new JSONObject();
		repository.save(meeting);
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}
	
	public JSONObject deleteMeeting(Meetings meeting) {

		JSONObject jsonObject = new JSONObject();
		repository.deleteById(meeting.getId());
		jsonObject.put("data", "SUCCESS");
		return jsonObject;

	}
	
	public List<Meetings> viewAllMeetings() {

		return repository.findAll();
	}


}
