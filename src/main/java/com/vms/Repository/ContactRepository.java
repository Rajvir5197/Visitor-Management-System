package com.vms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.ContactManager;

@Repository
public interface ContactRepository extends JpaRepository<ContactManager, Integer>{

	public List<ContactManager> findByRegBy(@Param("regBy") int userId);
}
