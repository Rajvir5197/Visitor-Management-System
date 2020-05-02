package com.vms.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.Employee;

@Repository
public interface LoginRepository extends JpaRepository<Employee, Integer> {
	
	public Optional<Employee> findByEmpMobile(@Param("empCode") long number);

}
