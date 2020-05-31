package com.vms.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.MeetingStatus;
import com.vms.Model.Plant;

@Repository
public interface MeetingStatusRepository extends JpaRepository<MeetingStatus, Integer> {

	public List<MeetingStatus> findByCreatedByAndMeetingBookedVisitDateAndStatusIsNotInAndEmpCheckout(@Param("createdBy") int empCode,@Param("visitDate") Date visitDate, @Param("status") List<String> status, @Param("empCheckout") boolean checkout);
	
	public List<MeetingStatus> findByMeetingBookedVisitDateAndStatusIsNotInAndMeetingBookedVisitLocationIn(@Param("visitDate") Date visitDate, @Param("status") List<String> status,@Param("plantCode") List<Plant> plantCode);

	public List<MeetingStatus> findByCreatedBy(@Param("createdBy") int userId);
	
	public List<MeetingStatus> findByStatusIsNotIn(@Param("status") List<String> status);
	
	public List<MeetingStatus> findByStatus(@Param("status") String status);
	
	public List<MeetingStatus> findByMeetingBookedVisitDateBetweenAndStatusIsNotIn(Date startDate, Date endDate,@Param("status") List<String> status);
}
