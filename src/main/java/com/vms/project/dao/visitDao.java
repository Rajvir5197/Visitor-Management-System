package com.vms.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vms.project.dto.VisitorInfo;

public interface visitDao extends JpaRepository<VisitorInfo, Integer> {

}
