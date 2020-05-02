package com.vms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.Model.Employee;
import com.vms.Model.Plant;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


}
