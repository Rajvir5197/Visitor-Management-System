package com.vms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer>{

	public List<Visitor> findByBatchStatus(@Param("batchStatus") String status);
}
