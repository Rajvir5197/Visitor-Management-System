package com.vms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

	 public List<Plant> findByActive(@Param("active") boolean active); 
}
