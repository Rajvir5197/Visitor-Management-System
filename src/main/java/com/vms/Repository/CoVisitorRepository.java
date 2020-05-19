package com.vms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.CoVisitor;
import com.vms.Model.Visitor;

@Repository
public interface CoVisitorRepository extends JpaRepository<CoVisitor, Integer>{
	
	public List<CoVisitor> findByVisitor(@Param("visitor") Visitor visitor);
	

}
