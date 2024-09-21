package com.agriculture_platform.Farm.Management.Service;

import com.agriculture_platform.Farm.Management.Entity.Crop;
import com.agriculture_platform.Farm.Management.Entity.Report;
import com.agriculture_platform.Farm.Management.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agriculture_platform.Farm.Management.Exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;


    public Report addReport(Report report) {
        report.setCreatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    public  List<Report> getCropByFarmId(Long farm_id){ return  reportRepository.findByFarmId(farm_id);}



    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Report not found"));
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
