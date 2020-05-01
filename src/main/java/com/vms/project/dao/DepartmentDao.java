package com.vms.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.project.dto.DepartmentMaster;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentMaster, Integer> {

}
