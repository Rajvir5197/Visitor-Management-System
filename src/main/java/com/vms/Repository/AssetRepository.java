package com.vms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vms.Model.Asset;
import com.vms.Model.CoVisitor;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

	public List<Asset> findByVisitor(@Param("visitor") CoVisitor visitor);
}
