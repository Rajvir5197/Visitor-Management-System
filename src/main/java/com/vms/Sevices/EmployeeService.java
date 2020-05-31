package com.vms.Sevices;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vms.Model.Asset;
import com.vms.Model.CoVisitor;
import com.vms.Model.ContactManager;
import com.vms.Model.Employee;
import com.vms.Model.MeetingStatus;
import com.vms.Model.Plant;
import com.vms.Model.Task;
import com.vms.Repository.AssetRepository;
import com.vms.Repository.CoVisitorRepository;
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
	
	@Autowired
	CoVisitorRepository coVisitorRepository;

	@Autowired
	AssetRepository assetRepository;
	/*
	 * @Autowired SessionFactory sessionFactory;
	 */

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public List<Employee> allEmployee() {

		logger.info("start of allEmployee method");
		List<Employee> E = repository.findByActive(true);
		logger.info("after fetching data:"+E.size());
		for (Employee emp : E) {
			if (emp.getImage() != null) {
				logger.info("before decompressing");
				emp.setImage(decompressBytes(emp.getImage()));
				logger.info("after decompressing");
			}
		}

		logger.info("end of allEmployee method");

		return E;
	}

	public JSONObject addNewEmp(Employee employee) {

		logger.info("start of addNewEmp method");
		JSONObject jsonObject = new JSONObject();
		if(isExists(employee)) {
			jsonObject.put("data", "Exist");
			return jsonObject;
		}
		employee.setRegDate(Date.valueOf(LocalDate.now()));
		employee.setRegTime(Time.valueOf(LocalTime.now()));
		if(employee.getImage() != null) {
			employee.setImage(compressBytes(employee.getImage()));
		}
		//employee.setImage(compressBytes(employee.getImage()));
		employee.setActive(true);
		Employee employeeSaved = repository.save(employee);
		if (null != employeeSaved) {
			jsonObject.put("data", "SUCCESS");
			logger.info("employee added: " + employeeSaved.getEmpCode());
		} else {
			jsonObject.put("data", "FAIL");
		}
		logger.info("end of addNewEmp method");
		return jsonObject;
	}
	
	public JSONObject EditNewEmp(Employee employee) {

		logger.info("start of addNewEmp method");
		JSONObject jsonObject = new JSONObject();
		employee.setRegDate(Date.valueOf(LocalDate.now()));
		employee.setRegTime(Time.valueOf(LocalTime.now()));
		if(employee.getImage() != null) {
			employee.setImage(compressBytes(employee.getImage()));
		}
		//employee.setImage(compressBytes(employee.getImage()));
		
		Employee employeeSaved = repository.save(employee);
		if (null != employeeSaved) {
			jsonObject.put("data", "SUCCESS");
			logger.info("employee added: " + employeeSaved.getEmpCode());
		} else {
			jsonObject.put("data", "FAIL");
		}
		logger.info("end of addNewEmp method");
		return jsonObject;
	}

	public JSONObject changePassword(Employee employee) {

		logger.info("start of addNewEmp method");
		JSONObject jsonObject = new JSONObject();
		employee.setRegDate(Date.valueOf(LocalDate.now()));
		employee.setRegTime(Time.valueOf(LocalTime.now()));
		if(employee.getImage() != null) {
			employee.setImage(compressBytes(employee.getImage()));
		}
		
		Employee employeeSaved = repository.save(employee);
		if (null != employeeSaved) {
			jsonObject.put("data", "SUCCESS");
			logger.info("employee added: " + employeeSaved.getEmpCode());
		} else {
			jsonObject.put("data", "FAIL");
		}
		logger.info("end of addNewEmp method");
		return jsonObject;
	}
	public JSONObject addEmployee(String jsonEmployee, MultipartFile file) {

		logger.info("start of addOrEditEmployee method");
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObject = new JSONObject();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Employee employee = mapper.readValue(jsonEmployee, Employee.class);
			// employee.setProfileAttachment(new SerialBlob(file.getBytes()));
			if(isExists(employee)) {
				jsonObject.put("data", "Exist");
				return jsonObject;
			}
			employee.setImage(compressBytes(file.getBytes()));
			//Blob blob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(file.getInputStream(), file.getSize());
			//employee.setProfileAttachment(blob);
			employee.setRegDate(Date.valueOf(LocalDate.now()));
			employee.setRegTime(Time.valueOf(LocalTime.now()));
			employee.setActive(true);
			Employee employeeSaved = repository.save(employee);
			if (null != employeeSaved) {
				jsonObject.put("data", "SUCCESS");
			} else {
				jsonObject.put("data", "FAIL");
			}
		} /*
			 * catch (SQLException e) {
			 * 
			 * e.printStackTrace();
			 * 
			 * }
			 */
		catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	public JSONObject editEmployee(String jsonEmployee, MultipartFile file) {

		logger.info("start of addOrEditEmployee method");
		ObjectMapper mapper = new ObjectMapper();
		JSONObject jsonObject = new JSONObject();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Employee employee = mapper.readValue(jsonEmployee, Employee.class);
			// employee.setProfileAttachment(new SerialBlob(file.getBytes()));
			employee.setImage(compressBytes(file.getBytes()));
			employee.setRegDate(Date.valueOf(LocalDate.now()));
			employee.setRegTime(Time.valueOf(LocalTime.now()));
			Employee employeeSaved = repository.save(employee);
			if (null != employeeSaved) {
				jsonObject.put("data", "SUCCESS");
			} else {
				jsonObject.put("data", "FAIL");
			}
		} /*
			 * catch (SQLException e) {
			 * 
			 * e.printStackTrace();
			 * 
			 * }
			 */
		catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	public boolean isExists(Employee employee) {
		Optional<Employee> l = repository.findById(employee.getEmpCode());
		if(l.isPresent()) {
			return true;
		}
			return false;
	}

	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("before compressed" + data.length);
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		//logger.info("before decompressing");
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {

		}
		return outputStream.toByteArray();
	}

	public JSONObject deleteEmployee(Employee employee) {

		JSONObject jsonObject = new JSONObject();
		employee.setEmpPlantCode(null);
		if(employee.getImage() != null) {
			employee.setImage(compressBytes(employee.getImage()));
		}
		employee.setActive(false);
		repository.save(employee);

		//repository.delete(employee);

		jsonObject.put("data", "SUCCESS");
		return jsonObject;

	}

	public List<ContactManager> viewAllContacts(int loginId) {

		List<ContactManager> allContacts = contactRepository.findByRegBy(loginId);
		/*
		 * int count = meetingStatusRepository.CreatedBy(loginId);
		 * System.out.println("count: " +count);
		 */
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

	public List<MeetingStatus> viewAllVisit(Employee employee) {

		logger.info("start of viewAllVisit method");
		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("Cancel");
		statusNotIn.add("Sec Checked Out");
		
		Optional<Employee> loginEmployee = repository.findById(employee.getEmpCode());
		
		List<Plant> plantsIn = new ArrayList<Plant>();
		if(null != loginEmployee.get().getEmpPlantCode()) {
			for(Plant plant: loginEmployee.get().getEmpPlantCode()) {
				plantsIn.add(plant);
			}
		}
		logger.info("visitDate: " + Date.valueOf(LocalDate.now()));
		List<MeetingStatus> allMeetings = meetingStatusRepository
				.findByMeetingBookedVisitDateAndStatusIsNotInAndMeetingBookedVisitLocationIn(Date.valueOf(LocalDate.now()), statusNotIn, plantsIn);
		

		for (MeetingStatus meetings : allMeetings) {
			
			if (meetings.getMeetingBooked().getVisitor().getVisitorImage() != null) {

				meetings.getMeetingBooked().getVisitor()
						.setVisitorImage(decompressBytes(meetings.getMeetingBooked().getVisitor().getVisitorImage()));
			}
		}

		logger.info("end of viewAllVisit method with meeting count: " + allMeetings.size());
		return allMeetings;
	}

	public List<MeetingStatus> viewAllVisitOfEmployee(int empCode) {

		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("Cancel");
		statusNotIn.add("Sec Checked Out");
		List<MeetingStatus> allMeetings = meetingStatusRepository
				.findByCreatedByAndMeetingBookedVisitDateAndStatusIsNotInAndEmpCheckout(empCode,
						Date.valueOf(LocalDate.now()), statusNotIn, false);
		/*
		 * for(MeetingStatus ms : allMeetings) {
		 * ms.getMeetingBooked().setVisitDate(Date.valueOf(LocalDate.now())); }
		 */
		return allMeetings;
	}

	public JSONObject addNewVisit(@RequestBody MeetingStatus meeting) {

		JSONObject jsonObject = new JSONObject();
		try {
			// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			/// java.util.Date d = sdf.parse(sdf.format(timestamp));
			Optional<Employee> employee = repository.findById(meeting.getMeetingBooked().getEmpId());
			Random rnd = new Random();
			// int number = Integer.valueOf(String.format("%06d", rnd.nextInt(999999)));
			int number = rnd.nextInt(900000) + 100000;
			meeting.setSecurityCode(number);
			meeting.getMeetingBooked().setVisitDepartment(employee.get().getEmpDept());
			meeting.setCreatedDate(Date.valueOf(LocalDate.now()));
			meeting.setCreatedTime(Time.valueOf(LocalTime.now()));
			meeting.setLastUpdatedDate(Date.valueOf(LocalDate.now()));
			meeting.setLastUpdatedTime(Time.valueOf(LocalTime.now()));
			meeting.setStatus("Booked");

			MeetingStatus meetingSaved = meetingStatusRepository.save(meeting);
			String mailStatus = sendMessage(meeting);
			if (null != meetingSaved /* && "SUCCESS".equalsIgnoreCase(mailStatus) */ ) {
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

	public List<Task> viewTask(int loginId) {
		System.out.println(getTotalVisitCount(loginId));
		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("COMPLETED");
		List<Task> allTask = taskRepository.findByCreatedByAndTaskStatusNotIn(loginId, statusNotIn);

		return allTask;
	}

	public JSONObject addTask(Task task) {

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

	public int getTotalVisitCount(int loginId) {
		List<MeetingStatus> allVisit = meetingStatusRepository.findByCreatedBy(loginId);
		int count = 0;
		for (MeetingStatus ms : allVisit) {
			count++;
		}

		return count;
	}
	
	public long getAllVisitCount() {
		
		return meetingStatusRepository.count();		
	}
	
	public long getAllEmployeeCount() {
		
		return repository.count();		
	}

	public int getTodaysVisitCount(int loginId) {

		logger.info("start of getTodaysVisitCount method");
		List<MeetingStatus> allVisit = meetingStatusRepository.findByCreatedBy(loginId);
		int count = 0;
		Date currentDate = Date.valueOf(LocalDate.now());
		logger.info("current Date: " + currentDate);
		for (MeetingStatus ms : allVisit) {
			logger.info("status of meeting " + ms.getMeetingId() + " is " + ms.getStatus());
			logger.info("visit date of meeeting " + ms.getMeetingId() + " is " + ms.getMeetingBooked().getVisitDate());
			logger.info("value of date compareTo current date is "
					+ currentDate.compareTo(ms.getMeetingBooked().getVisitDate()));
			if ((currentDate.compareTo(ms.getMeetingBooked().getVisitDate()) == 0)
					&& (!"Cancel".equalsIgnoreCase(ms.getStatus()))) {
				count++;
			}
		}
		logger.info("end of getTodaysVisitCount method with count = " + count);

		// int count = getTotalVisitCount(loginId) - getCancelVisitCount(loginId)
		// -getAttendedVisitCount(loginId);
		return count;
	}

	public int getCancelVisitCount(int loginId) {
		List<MeetingStatus> allVisit = meetingStatusRepository.findByCreatedBy(loginId);
		int count = 0;
		for (MeetingStatus ms : allVisit) {

			if ("Cancel".equalsIgnoreCase(ms.getStatus())) {
				count++;
			}
		}

		return count;
	}

	public int getAttendedVisitCount(int loginId) {
		List<MeetingStatus> allVisit = meetingStatusRepository.findByCreatedBy(loginId);
		int count = 0;
		Date currentDate = Date.valueOf(LocalDate.now());
		for (MeetingStatus ms : allVisit) {

			if ("Sec Checked Out".equalsIgnoreCase(ms.getStatus())) {
				count++;
			}
		}

		return count;
	}

	public String sendMessage(MeetingStatus visitor) {
		URL url = null;
	    BufferedReader reader = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String message1 = null;
	    String subject = null;
	    String message = null;
		
	    if("cancel".equalsIgnoreCase(visitor.getStatus())) {
	    	subject = "You scheduled visit is cancelled with Rucha Engineers Pvt Ltd.";
	    	message1 = "Hello, " + visitor.getMeetingBooked().getVisitor().getVisitorName()+", sorry to inform you that your scheduled visit on " +sdf.format(visitor.getMeetingBooked().getVisitDate()) + " at "
					+ visitor.getMeetingBooked().getVisitTime() +" is cancelled.";
	    	message = message1.replaceAll(" ", "%20");
	    }else {
	    	subject = "Your visit is scheduled at Rucha Engineers Pvt Ltd.";
	    	message1 = "Hello, " + visitor.getMeetingBooked().getVisitor().getVisitorName()+ " Your Visit is schedule with " + visitor.getMeetingBooked().getEmpName() +
	    			" on " + sdf.format(visitor.getMeetingBooked().getVisitDate()) + " at " + visitor.getMeetingBooked().getVisitTime() 
					+ " in " + visitor.getMeetingBooked().getVisitLocation().getPlantName() + ". And your Appointment Number is: "
					+ visitor.getSecurityCode();
	    	message = message1.replaceAll(" ", "%20");
	    	message1 = message1 + "/n Visit Location: "+visitor.getMeetingBooked().getVisitLocation().getPlantMapLink();
	    }
	    
	    //String message = "hello";
		 try
		    {
		      // create the HttpURLConnection
			 String urlStr = "http://bulksms.vrudheesolutions.com/api/mt/SendSMS?APIKey=R8ntvc8nnU26zeAGiN0U0A&senderid=ERUCHA&channel=2&DCS=0&flashsms=0&number="+visitor.getMeetingBooked().getVisitor().getContactNumber()+"&text="+message+"&route=1";
			 logger.info(urlStr);
		      url = new URL(urlStr);
		      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		      connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		      
		      // give it 15 seconds to respond
		      connection.setReadTimeout(15*1000);
		      connection.connect();
		
		      // read the output from the server
		      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		      
		
		      String line = null;
		      while ((line = reader.readLine()) != null)
		      {
		        stringBuilder.append(line + "\n");
		      }
		      sendmail(visitor.getMeetingBooked().getVisitor().getEmailId(),message1,subject);
		     
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		    }
		 return (stringBuilder.toString());
	}

	public void sendmail(String MailTo, String message, String subject) throws AddressException, MessagingException, IOException {
		SimpleMailMessage msg = new SimpleMailMessage();
		//msg.setFrom("raj.viradiya@syscort.com");no-reply@rucha.co.in
		msg.setFrom("no-reply@rucha.co.in");
		msg.setTo(MailTo);

		msg.setSubject(subject);
		msg.setText(message);

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
			sendMessage(meetingSaved);
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

	public Employee getLoggedInDetails(int loginId) {

		logger.info("start of getLoggedInDetails method with loginId:"+loginId);
		Employee empDetails = new Employee();
		Optional<Employee> l = repository.findById(loginId);
		logger.info("after hiting repository:"+l.get().getEmpName());
		if (l.isPresent()) {
			empDetails = l.get();
			logger.info("before compressing image");
			if (empDetails.getImage() != null) {

				empDetails.setImage(decompressBytes(empDetails.getImage()));
				logger.info("after compressing image"+empDetails.getImage().length);
			}

		}
		logger.info("end of getLoggedInDetails method with loginId:"+loginId);
		return empDetails;
	}

	public List<MeetingStatus> viewAllVisitsReport() {

		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("Cancel");
		List<MeetingStatus> allMeetings = meetingStatusRepository.findByStatusIsNotIn(statusNotIn);
		
		for(MeetingStatus meeting : allMeetings) {
			if(meeting.getMeetingBooked().getVisitor().getVisitorImage() != null) {
				meeting.getMeetingBooked().getVisitor().setVisitorImage(decompressBytes(meeting.getMeetingBooked().getVisitor().getVisitorImage()));
			}
		}
		return allMeetings;
	}

	public List<MeetingStatus> viewAllCancelVisitsReport() {

		List<MeetingStatus> allCancelMeetings = meetingStatusRepository.findByStatus("Cancel");

		return allCancelMeetings;
	}

	public List<MeetingStatus> getVisitsbetweenDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub

		List<String> statusNotIn = new ArrayList<String>();
		statusNotIn.add("Cancel");
		List<MeetingStatus> allMeetings = meetingStatusRepository
				.findByMeetingBookedVisitDateBetweenAndStatusIsNotIn(startDate, endDate, statusNotIn);

		return allMeetings;

	}

	public ByteArrayInputStream customersToExcel(List<MeetingStatus> visits) throws IOException {

		logger.info("start of customersToExcel method");
		String[] COLUMNs = { "Visitor Name", "Visitor Org", "visitor Phone", "Visit Date", "Visit Time" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("VisitorDetails");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			int rowIdx = 1;
			logger.info("size of data:" + visits.size());
			for (MeetingStatus visit : visits) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(visit.getMeetingBooked().getVisitor().getVisitorName());
				row.createCell(1).setCellValue(visit.getMeetingBooked().getVisitor().getOrganisation());
				row.createCell(2).setCellValue(visit.getMeetingBooked().getVisitor().getContactNumber());
				row.createCell(3).setCellValue(visit.getMeetingBooked().getVisitDate().toString());
				row.createCell(4).setCellValue(visit.getMeetingBooked().getVisitTime().toString());

			}

			workbook.write(out);
			logger.info("end of customersToExcel method");
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
	
	public JSONObject sendEmail(MeetingStatus meeting) {
		
		JSONObject jsonObject = new JSONObject();
		try {
			// Construct data
			String Greet = "Dear " + meeting.getMeetingBooked().getVisitor().getVisitorName() + "\n\n\n";
			
			String CoVisitorList = "";
			List<CoVisitor> CoVisitorListdetails = coVisitorRepository.findByVisitor(meeting.getMeetingBooked().getVisitor());
			int CoVisitorCount = 1;
			int AssetCount = 1 ;
			for (CoVisitor CV : CoVisitorListdetails) {
				CoVisitorList = CoVisitorList + "Co-Visitor " + CoVisitorCount + ": " + CV.getCoVisitorName() + "\n";
				CoVisitorCount++;
			}
			String AssetMain;
			String subject;
			if(meeting.isEmpCheckout() || "cancel".equalsIgnoreCase(meeting.getStatus())) {
				subject="checkin Details";
				AssetMain = "Below is the list of Asset details at the time of check-out: \n";
			}else {
				subject="checkout Details";
				AssetMain = "Below is the list of Asset details stored in Locker: \n";
			}
			 
			String AssetDetailsM = "";
			List<Asset> assetDetailsMAin = assetRepository.findByMainVisitor(meeting.getMeetingBooked().getVisitor());
			for (Asset as : assetDetailsMAin) {
				AssetDetailsM = AssetDetailsM + "Asset " + AssetCount  + ": " + as.getAssetName() +" "+ as.getAssetCount() + " Nos.\n";
				if(meeting.isEmpCheckout() || "cancel".equalsIgnoreCase(meeting.getStatus())) {
					AssetDetailsM = AssetDetailsM + as.getAssetStatus() + "\n";
				}
				AssetCount++;
			}
			for (CoVisitor CV : CoVisitorListdetails) {
				List<Asset> assetDetails = assetRepository.findByVisitor(CV);
				for (Asset as : assetDetails) {
					AssetDetailsM = AssetDetailsM + "Asset " + AssetCount + ": " + as.getAssetName() +" "+ as.getAssetCount() + " Nos.\n";
					if(meeting.isEmpCheckout() || "cancel".equalsIgnoreCase(meeting.getStatus())) {
						AssetDetailsM = AssetDetailsM + as.getAssetStatus() + "\n";
					}
					AssetCount++;
				}
			}
			
			String message = Greet + CoVisitorList + AssetMain + AssetDetailsM + "\n\n" +meeting.getSecCheckinBy() + "\n" + meeting.getMeetingBooked().getVisitLocation().getPlantAddress() +"\n";
			sendmail(meeting.getMeetingBooked().getVisitor().getEmailId(),message,subject);
		     
	    } catch (Exception e) {
			System.out.println("Error SMS "+e);
			logger.info("Error "+e);
		}
		jsonObject.put("msg", "SUCCESS");
		return jsonObject;
	}

}
