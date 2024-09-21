package com.agriculture_platform.Farm.Management.Controller;

import com.agriculture_platform.Farm.Management.Entity.Farm;
import com.agriculture_platform.Farm.Management.Service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
public class FarmController {
    @Autowired
    private FarmService farmService;


    @GetMapping
    public ResponseEntity<List<Farm>> getAllFarms() {
        List<Farm> farms = farmService.getAllFarms();
        return new ResponseEntity<>(farms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarmById(@PathVariable Long id) {
        Farm farm = farmService.getFarmById(id);
        if (farm != null) {
            return new ResponseEntity<>(farm, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Farm> addFarm(@RequestBody Farm farm) {
        Farm newFarm = farmService.addFarm(farm);
        return new ResponseEntity<>(newFarm, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable Long id, @RequestBody Farm farm) {
        Farm existingFarm = farmService.getFarmById(id);
        if (existingFarm == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update fields
        if (farm.getFarmerId() != null) {
            existingFarm.setFarmerId(farm.getFarmerId());
        }
        if (farm.getName() != null) {
            existingFarm.setName(farm.getName());
        }
        if (farm.getLocation() != null) {
            existingFarm.setLocation(farm.getLocation());
        }
        if (farm.getSize() != 0) { // Assuming size 0 means not set
            existingFarm.setSize(farm.getSize());
        }
        if (farm.getCropType() != null) {
            existingFarm.setCropType(farm.getCropType());
        }

        // Update crops, reports, and tasks as needed, if those fields can be modified directly
        if (farm.getCrops() != null) {
            existingFarm.setCrops(farm.getCrops());
        }
        if (farm.getReports() != null) {
            existingFarm.setReports(farm.getReports());
        }
        if (farm.getTasks() != null) {
            existingFarm.setTasks(farm.getTasks());
        }

        Farm updatedFarm = farmService.addFarm(existingFarm);
        return new ResponseEntity<>(updatedFarm, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
