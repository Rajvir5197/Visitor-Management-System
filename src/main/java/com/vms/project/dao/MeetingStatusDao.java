package com.vms.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vms.project.dto.MeetingStatus;

public interface MeetingStatusDao extends JpaRepository<MeetingStatus, Integer> {

}
