package com.agriculture_platform.Farm.Management.Controller;

import com.agriculture_platform.Farm.Management.Entity.Report;
import com.agriculture_platform.Farm.Management.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;


    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        Report report = reportService.getReportById(id);
        if (report != null) {
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        Report newReport = reportService.addReport(report);
        return new ResponseEntity<>(newReport, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
