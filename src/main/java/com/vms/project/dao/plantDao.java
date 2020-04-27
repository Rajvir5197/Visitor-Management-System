package com.vms.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.project.dto.PlantMaster;

@Repository
public interface plantDao extends JpaRepository<PlantMaster, Integer> {

}
