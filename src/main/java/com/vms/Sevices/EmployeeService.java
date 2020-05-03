package com.vms.Sevices;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.vms.Model.ContactManager;
import com.vms.Model.Employee;
import com.vms.Model.MeetingStatus;
import com.vms.Model.Task;
import com.vms.Repository.ContactRepository;
import com.vms.Repository.EmployeeRepository;
import com.vms.Repository.MeetingStatusRepository;
import com.vms.Repository.TaskRepository;

import net.minidev.json.JSONObject;

@Service
public class EmployeeService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	EmployeeRepository repository;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	MeetingStatusRepository meetingStatusRepository;

	@Autowired
	TaskRepository taskRepository;
	
	public List<Employee> allEmployee() {

		return repository.findAll();
	}

	public JSONObject addOrEditEmployee(String jsonEmployee, MultipartFile file) {

		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObject = new JSONObject();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {

			Employee employee = mapper.readValue(jsonEmployee, Employee.class);
			// employee.setProfileAttachment(new SerialBlob(file.getBytes()));
			employee.setRegDate(Date.valueOf(LocalDate.now()));
			employee.setRegTime(Time.valueOf(LocalTime.now()));
			Employee employeeSaved = repository.save(employee);
			if (null != employeeSaved) {
				jsonObject.put("data", "SUCCESS");
			} else {
				jsonObject.put("data", "FAIL");
			}
		} /*
			 * catch (SQLException e) { e.printStackTrace(); }
			 */ catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	public JSONObject deleteEmployee(Employee employee) {

		JSONObject jsonObject = new JSONObject();

		repository.delete(employee);

		jsonObject.put("data", "SUCCESS");
		return jsonObject;

	}

	public List<ContactManager> viewAllContacts(int loginId) {

		List<ContactManager> allContacts = contactRepository.findByRegBy(loginId);
		
		return allContacts;
	}

	public JSONObject addNewOrEditContact(ContactManager contact) {

		JSONObject jsonObject = new JSONObject();
		contact.setRegDate(Date.valueOf(LocalDate.now()));
		contact.setRegTime(Time.valueOf(LocalTime.now()));
		ContactManager contanctSaved = contactRepository.save(contact);
		if (null != contanctSaved) {
			jsonObject.put("msg", "SUCCESS");
		} else {
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;
	}

	public JSONObject deleteContact(ContactManager contact) {

		contact.setRegDate(Date.valueOf(LocalDate.now()));
		contact.setRegTime(Time.valueOf(LocalTime.now()));
		JSONObject jsonObject = new JSONObject();
		contactRepository.delete(contact);
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}

	public List<MeetingStatus> viewAllVisit() {
		
		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("Cancel");
		statusNotIn.add("Sec Checked Out");
		List<MeetingStatus> allMeetings = meetingStatusRepository.findByMeetingBookedVisitDateAndStatusIsNotIn(Date.valueOf(LocalDate.now()),statusNotIn);

		return allMeetings;
	}
	
	public List<MeetingStatus> viewAllVisitOfEmployee(int empCode) {
		
		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("Cancel");
		List<MeetingStatus> allMeetings = meetingStatusRepository.findByCreatedByAndMeetingBookedVisitDateAndStatusIsNotIn(empCode, Date.valueOf(LocalDate.now()),statusNotIn);

		return allMeetings;
	}

	public JSONObject addNewVisit(@RequestBody MeetingStatus meeting) {

		JSONObject jsonObject = new JSONObject();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			///java.util.Date d = sdf.parse(sdf.format(timestamp));
			meeting.setCreatedDate(Date.valueOf(LocalDate.now()));
			meeting.setCreatedTime(Time.valueOf(LocalTime.now()));
			meeting.setLastUpdatedDate(Date.valueOf(LocalDate.now()));
			meeting.setLastUpdatedTime(Time.valueOf(LocalTime.now()));
			meeting.setStatus("Booked");

			MeetingStatus meetingSaved = meetingStatusRepository.save(meeting);
			//String mailStatus = sendMessage(meeting);
			if (null != meetingSaved /* && "SUCCESS".equalsIgnoreCase(mailStatus) */) {
				jsonObject.put("msg", "SUCCESS");
				jsonObject.put("meetingData", meetingSaved);
			} else {
				jsonObject.put("msg", "FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;

	}

	public JSONObject deleteVisit(MeetingStatus meeting) {

		JSONObject jsonObject = new JSONObject();
		meetingStatusRepository.delete(meeting);
		jsonObject.put("data", "SUCCESS");
		return jsonObject;
	}

	public JSONObject empCheckIn(MeetingStatus meeting) {

		JSONObject jsonObject = new JSONObject();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			meeting.setLastUpdatedDate(Date.valueOf(LocalDate.now()));
			meeting.setLastUpdatedTime(Time.valueOf(LocalTime.now()));
			meeting.setStatus("Checked In");
			meeting.setEmpCheckin(true);
			meeting.setEmpCheckinDate(Date.valueOf(LocalDate.now()));
			meeting.setEmpCheckinTime(Time.valueOf(LocalTime.now()));

			MeetingStatus meetingSaved = meetingStatusRepository.save(meeting);
			if (null != meetingSaved) {
				jsonObject.put("msg", "SUCCESS");
			} else {
				jsonObject.put("msg", "FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;

	}
	
	public JSONObject empCheckOut(MeetingStatus meeting) {
		
		JSONObject jsonObject = new JSONObject();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			meeting.setLastUpdatedDate(Date.valueOf(LocalDate.now()));
			meeting.setLastUpdatedTime(Time.valueOf(LocalTime.now()));
			meeting.setStatus("Checked Out");
			meeting.setEmpCheckout(true);
			meeting.setEmpCheckoutDate(Date.valueOf(LocalDate.now()));
			meeting.setEmpCheckoutTime(Time.valueOf(LocalTime.now()));
			
			MeetingStatus meetingSaved = meetingStatusRepository.save(meeting);
			if(null != meetingSaved) {
				jsonObject.put("msg", "SUCCESS");
			}else {
				jsonObject.put("msg", "FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;
	
	}
	
	public List<Task> viewTask(int loginId) {

		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("COMPLETED");
		List<Task> allTask = taskRepository.findByCreatedByAndTaskStatusNotIn(loginId,statusNotIn);

		return allTask;
	}
	
	public JSONObject addTask(Task task){

		JSONObject jsonObject = new JSONObject();
		task.setCreatedDate(Date.valueOf(LocalDate.now()));
		task.setCreatedTime(Time.valueOf(LocalTime.now()));
		task.setTaskStatus("CREATED");
		Task TaskSaved = taskRepository.save(task);
		if (null != TaskSaved) {
			jsonObject.put("msg", "SUCCESS");
		} else {
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;
	}
	
	public JSONObject completeTask(Task task) {
		
		JSONObject jsonObject = new JSONObject();
		task.setCompletedDate(Date.valueOf(LocalDate.now()));
		task.setCompletedTime(Time.valueOf(LocalTime.now()));
		task.setTaskStatus("COMPLETED");
		Task TaskSaved = taskRepository.save(task);
		if (null != TaskSaved) {
			jsonObject.put("msg", "SUCCESS");
		} else {
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;
	}

	public String sendMessage(@RequestBody MeetingStatus visitor) {
		try {
			// Construct data
			// APIKey=R8ntvc8nnU26zeAGiN0U0A&senderid=ERUCHA&channel=2&DCS=0&
			// flashsms=0&number=919028xxxxxx&text=test%20message&route=1
			// SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			// String apiKey = "APIKey=" +
			// URLEncoder.encode("R8ntvc8nnU26zeAGiN0U0A","UTF-8")+"&senderid="+URLEncoder.encode("ERUCHA","UTF-8")+"&channel="+URLEncoder.encode("2","UTF-8")+"&DCS="+URLEncoder.encode("0","UTF-8")+"&flashsms="+URLEncoder.encode("0","UTF-8");
			// String message = "Your Meeting is schedule on "+
			// sdf.format(visitor.getMeetingBooked().getVisitDate()) +"
			// "+visitor.getMeetingBooked().getVisitTime()
			// +" with "+visitor.getMeetingBooked().getEmpId()+" at
			// "+visitor.getMeetingBooked().getVisitLocation()+"&route=1";
			// String numbers = "&numbers=" +
			// URLEncoder.encode(""+visitor.getMeetingBooked().getVisitor().getContactNumber(),"UTF-8");

			// Send data
			// HttpURLConnection conn = (HttpURLConnection) new
			// URL("http://bulksms.vrudheesolutions.com/api/mt/SendSMS?").openConnection();
			// conn.setRequestProperty("Content-Type", "application/json");
			// String data = apiKey + numbers +"&text=" +
			// URLEncoder.encode(message,"UTF-8"); //+ sender;
			// String data1 ="{APIKey: \"R8ntvc8nnU26zeAGiN0U0A\", senderid: \"ERUCHA\",
			// channel: \"2\", DCS: \"0\", flashsms: \"0\", numbers:
			// \""+visitor.getMeetingBooked().getVisitor().getContactNumber()+
			// "\" , text: \"testMessage\" }";
			// System.out.println("data: "+ data);
			// conn.setDoOutput(true);
			// OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			// wr.write(data);
			// wr.flush();
			// BufferedReader rd = new BufferedReader(new
			// InputStreamReader(conn.getInputStream()));
			// String result = rd.readLine();
			// wr.close();
			// rd.close();

			sendmail(visitor.getMeetingBooked().getVisitor().getEmailId());

			// return result;
			return "SUCCESS";
		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}
	}

	public void sendmail(String MailTo) throws AddressException, MessagingException, IOException {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("raj.viradiya@syscort.com");
		msg.setTo(MailTo);

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		System.out.println("sending msg");
		javaMailSender.send(msg);
		System.out.println("sent msg");
	}

	public Employee getEmpPlant(Employee employee) {
		
		Optional<Employee> l = repository.findById(employee.getEmpCode());
		return l.get();
	}

	public JSONObject cancelVisit(MeetingStatus meeting) {

		JSONObject jsonObject = new JSONObject();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			meeting.setLastUpdatedDate(Date.valueOf(LocalDate.now()));
			meeting.setLastUpdatedTime(Time.valueOf(LocalTime.now()));
			meeting.setStatus("Cancel");

			MeetingStatus meetingSaved = meetingStatusRepository.save(meeting);
			if (null != meetingSaved) {
				jsonObject.put("msg", "SUCCESS");
			} else {
				jsonObject.put("msg", "FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;

	}

}
