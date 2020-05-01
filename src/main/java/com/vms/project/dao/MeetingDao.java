package com.vms.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vms.project.dto.MeetingBooking;

public interface MeetingDao extends JpaRepository<MeetingBooking, Integer> {

}
