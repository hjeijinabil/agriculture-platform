package com.agriculture_platform.Farm.Management.Repository;

import com.agriculture_platform.Farm.Management.Entity.Farm;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends JpaRepository<Farm,Long> {
    List<Farm> findByFarmerId(Long farmerId);

}
