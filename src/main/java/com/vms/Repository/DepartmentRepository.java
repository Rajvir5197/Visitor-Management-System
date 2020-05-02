package com.vms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
