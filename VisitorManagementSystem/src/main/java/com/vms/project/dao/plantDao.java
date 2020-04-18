package com.vms.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vms.project.dto.PlantMaster;

public interface plantDao extends JpaRepository<PlantMaster, Integer> {

}
