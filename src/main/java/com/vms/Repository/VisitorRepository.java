package com.vms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.Model.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer>{

}
