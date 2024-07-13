package com.agriculture_platform.Farm.Management.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private double yield;
    private Date plantingDate;
    private Date harvestDate;
    private String cropStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farm_id")
    private Farm farm;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public Date getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(Date plantingDate) {
        this.plantingDate = plantingDate;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(Date harvestDate) {
        this.harvestDate = harvestDate;
    }

    public String getCropStatus() {
        return cropStatus;
    }

    public void setCropStatus(String cropStatus) {
        this.cropStatus = cropStatus;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
