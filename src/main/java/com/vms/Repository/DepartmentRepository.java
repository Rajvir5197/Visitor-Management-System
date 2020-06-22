package com.vms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	public List<Department> findByActive(@Param("active") boolean active);
}
