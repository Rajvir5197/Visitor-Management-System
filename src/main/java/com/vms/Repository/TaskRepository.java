package com.vms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	public List<Task> viewByEmployee(@Param("createdBy") int userId);


}
