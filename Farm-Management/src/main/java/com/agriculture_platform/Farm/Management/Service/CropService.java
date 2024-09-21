package com.agriculture_platform.Farm.Management.Service;

import com.agriculture_platform.Farm.Management.Entity.Crop;
import com.agriculture_platform.Farm.Management.Entity.Farm;
import com.agriculture_platform.Farm.Management.Exception.ResourceNotFoundException;
import com.agriculture_platform.Farm.Management.Repository.CropRepository;
import com.agriculture_platform.Farm.Management.Repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;


public  List<Crop> getCropByFarmId(Long farm_id){ return  cropRepository.findByFarmId(farm_id);}
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }
    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }





    public Crop getCropById(Long id) {
        return cropRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Crop not found"));
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }

}
