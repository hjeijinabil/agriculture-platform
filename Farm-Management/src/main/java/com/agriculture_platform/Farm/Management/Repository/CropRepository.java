package com.agriculture_platform.Farm.Management.Repository;

import com.agriculture_platform.Farm.Management.Entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CropRepository extends JpaRepository<Crop,Long> {
//    List<Crop> findByFarmId(Long farmId);
}
