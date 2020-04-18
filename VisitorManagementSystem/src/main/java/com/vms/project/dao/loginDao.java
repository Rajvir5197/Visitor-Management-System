package com.vms.project.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.project.dto.EmployeeMaster;


@Repository
public interface loginDao extends JpaRepository<EmployeeMaster, Integer> {

	public Optional<EmployeeMaster> findByEmpMobile(@Param("empMobile") long number);
}
