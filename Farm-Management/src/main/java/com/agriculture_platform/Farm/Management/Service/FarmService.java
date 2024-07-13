package com.agriculture_platform.Farm.Management.Service;
import com.agriculture_platform.Farm.Management.Exception.ResourceNotFoundException;

import com.agriculture_platform.Farm.Management.Entity.Farm;
import com.agriculture_platform.Farm.Management.Repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;


    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }
    public Farm addFarm(Farm farm) {
        return farmRepository.save(farm);
    }

    public Farm updateFarm(Long id, Farm farmDetails) {
        Farm farm = farmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
        farm.setName(farmDetails.getName());
        farm.setLocation(farmDetails.getLocation());
        farm.setSize(farmDetails.getSize());
        farm.setCropType(farmDetails.getCropType());
        return farmRepository.save(farm);
    }

    public List<Farm> getFarmsByFarmerId(Long farmerId) {
        return farmRepository.findByFarmerId(farmerId);
    }

    public Farm getFarmById(Long id) {
        return farmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Farm not found"));
    }

    public void deleteFarm(Long id) {
        farmRepository.deleteById(id);
    }
}
