package com.vms.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.project.dto.ContactManagerDto;

@Repository
public interface ContactDao extends JpaRepository<ContactManagerDto, Integer>{

	public List<ContactManagerDto> findByRegBy(@Param("regBy") int userId);
}
