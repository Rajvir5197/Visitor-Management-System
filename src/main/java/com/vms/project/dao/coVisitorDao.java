package com.vms.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.vms.project.dto.CoVisitorDetails;
import com.vms.project.dto.VisitorInfo;


public interface coVisitorDao extends JpaRepository<CoVisitorDetails, Integer> {

	public List<CoVisitorDetails> findByVisitor(@Param("visitor") VisitorInfo visitor);
}
