package com.vms.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.vms.project.dto.AssetDetails;
import com.vms.project.dto.CoVisitorDetails;

public interface AssetDao extends JpaRepository<AssetDetails, Integer> {

	public List<AssetDetails> findByVisitor(@Param("visitor") CoVisitorDetails visitor);
}
