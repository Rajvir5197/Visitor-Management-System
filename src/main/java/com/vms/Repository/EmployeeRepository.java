package com.vms.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.Department;
import com.vms.Model.Employee;
import com.vms.Model.Plant;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public List<Employee> findByEmpDept(@Param("empDept") Department department);
	
}
