package com.agriculture_platform.Farm.Management.Controller;

import com.agriculture_platform.Farm.Management.Entity.Crop;
import com.agriculture_platform.Farm.Management.Entity.Farm;
import com.agriculture_platform.Farm.Management.Service.CropService;
import com.agriculture_platform.Farm.Management.Service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CropController {
    @Autowired
    private CropService cropService;


    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        List<Crop> crops = cropService.getAllCrops();
        return new ResponseEntity<>(crops, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable Long id) {
        Crop crop = cropService.getCropById(id);
        if (crop != null) {
            return new ResponseEntity<>(crop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @PostMapping
    public ResponseEntity<Crop> addCrop(@RequestBody Crop crop) {
        Crop newCrop = cropService.addCrop(crop);
        return new ResponseEntity<>(newCrop, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
