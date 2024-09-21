package com.agriculture_platform.Farm.Management.Repository;

import com.agriculture_platform.Farm.Management.Entity.Crop;
import com.agriculture_platform.Farm.Management.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
    @Query("SELECT c FROM Report c WHERE c.farm.id = :farm_id")
    List<Report> findByFarmId(@Param("farm_id") Long farm_id);
}
