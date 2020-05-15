package com.vms.Sevices;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vms.Model.Asset;
import com.vms.Model.CoVisitor;
import com.vms.Model.Employee;
import com.vms.Model.MeetingStatus;
import com.vms.Model.Visitor;
import com.vms.Repository.AssetRepository;
import com.vms.Repository.CoVisitorRepository;
import com.vms.Repository.MeetingStatusRepository;
import com.vms.Repository.VisitorRepository;

import net.minidev.json.JSONObject;

@Service
public class SecurityService {

	@Autowired
	CoVisitorRepository coVisitorRepository;

	@Autowired
	AssetRepository assetRepository;
	
	@Autowired
	MeetingStatusRepository meetingStatusRepository;
	
	@Autowired
	VisitorRepository visitorRepository;

	public JSONObject addCoVisitor(CoVisitor coVisitor) {

		JSONObject jsonObject = new JSONObject();
		coVisitor.setCreatedDate(Date.valueOf(LocalDate.now()));
		coVisitor.setCreatedTime(Time.valueOf(LocalTime.now()));

		CoVisitor coVisitorSaved = coVisitorRepository.save(coVisitor);
		if (null != coVisitorSaved) {
			int numberOfCovisitor = coVisitorSaved.getVisitor().getNumberOfCoVisitor();
			coVisitorSaved.getVisitor().setNumberOfCoVisitor(numberOfCovisitor+1);
			Visitor visitorSaved = visitorRepository.save(coVisitorSaved.getVisitor());
			if (null != visitorSaved) {
				jsonObject.put("msg", "SUCCESS");
			} else {
				jsonObject.put("msg", "FAIL");
			}
		} else {
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;

	}

	public List<CoVisitor> viewAllCoVisitor(MeetingStatus meeting) {

		List<CoVisitor> allCoVisitor = coVisitorRepository.findByVisitor(meeting.getMeetingBooked().getVisitor());
		return allCoVisitor;
	}

	public List<Asset> getAllAsset(CoVisitor coVisitor) {

		List<Asset> CoVisitor = assetRepository.findByVisitor(coVisitor);

		return CoVisitor;
	}

	public JSONObject addCoVisitorAsset(@RequestBody Asset asset) {

		JSONObject jsonObject = new JSONObject();

		Asset assetSaved = assetRepository.save(asset);
		if (null != assetSaved) {
			jsonObject.put("msg", "SUCCESS");
		} else {
			jsonObject.put("msg", "FAIL");
		}
		return jsonObject;

	}

	public JSONObject securityCheckin(MeetingStatus meeting) {

		JSONObject jsonObject = new JSONObject();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			meeting.setLastUpdatedDate(Date.valueOf(LocalDate.now()));
			meeting.setLastUpdatedTime(Time.valueOf(LocalTime.now()));
			meeting.setStatus("Sec Checked In");
			meeting.setSecCheckin(true);
			meeting.setSecCheckinDate(Date.valueOf(LocalDate.now()));
			meeting.setSecCheckinTime(Time.valueOf(LocalTime.now()));

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

	public JSONObject securityCheckout(MeetingStatus meeting) {

		JSONObject jsonObject = new JSONObject();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			meeting.setLastUpdatedDate(Date.valueOf(LocalDate.now()));
			meeting.setLastUpdatedTime(Time.valueOf(LocalTime.now()));
			meeting.setStatus("Sec Checked Out");
			meeting.setSecCheckout(true);
			meeting.setSecCheckoutDate(Date.valueOf(LocalDate.now()));
			meeting.setSecCheckoutTime(Time.valueOf(LocalTime.now()));

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

	public JSONObject addVisitorImage(MeetingStatus visitor) {

		//logger.info("start of addOrEditEmployee method");
		JSONObject jsonObject = new JSONObject();
		//employee.setProfileAttachment(new SerialBlob(file.getBytes()));
		visitor.getMeetingBooked().getVisitor().setVisitorImage(compressBytes(visitor.getMeetingBooked().getVisitor().getVisitorImage()));
		
		MeetingStatus visitorSaved = meetingStatusRepository.save(visitor);
		if (null != visitorSaved) {
			jsonObject.put("data", "SUCCESS");
		} else {
			jsonObject.put("data", "FAIL");
		}
		return jsonObject;
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

}
