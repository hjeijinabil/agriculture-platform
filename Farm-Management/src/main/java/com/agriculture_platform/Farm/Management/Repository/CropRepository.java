package com.agriculture_platform.Farm.Management.Repository;

import com.agriculture_platform.Farm.Management.Entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CropRepository extends JpaRepository<Crop,Long> {
    // Custom JPQL query to find crops by farmId
    @Query("SELECT c FROM Crop c WHERE c.farm.id = :farm_id")
    List<Crop> findByFarmId(@Param("farm_id") Long farm_id);
}
