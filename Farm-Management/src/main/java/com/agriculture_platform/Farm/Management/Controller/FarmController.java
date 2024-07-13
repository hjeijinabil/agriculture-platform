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
        Farm updatedFarm = farmService.updateFarm(id, farm);
        if (updatedFarm != null) {
            return new ResponseEntity<>(updatedFarm, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarm(@PathVariable Long id) {
        farmService.deleteFarm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
