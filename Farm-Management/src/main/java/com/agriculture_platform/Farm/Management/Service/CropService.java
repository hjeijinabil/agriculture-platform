package com.agriculture_platform.Farm.Management.Service;

import com.agriculture_platform.Farm.Management.Entity.Crop;
import com.agriculture_platform.Farm.Management.Exception.ResourceNotFoundException;
import com.agriculture_platform.Farm.Management.Repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {
    @Autowired
    private CropRepository cropRepository;


}
