package com.vms.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.MeetingStatus;

@Repository
public interface MeetingStatusRepository extends JpaRepository<MeetingStatus, Integer> {

	public List<MeetingStatus> findByCreatedByAndMeetingBookedVisitDateAndStatusIsNotIn(@Param("createdBy") int empCode,@Param("visitDate") Date visitDate, @Param("status") List<String> status);
	
	public List<MeetingStatus> findByMeetingBookedVisitDateAndStatusIsNotIn(@Param("visitDate") Date visitDate, @Param("status") List<String> status);
}
