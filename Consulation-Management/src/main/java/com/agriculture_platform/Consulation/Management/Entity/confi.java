package com.agriculture_platform.Consulation.Management.Entity;

import com.agriculture_platform.Consulation.Management.Repository.ConsultationBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class confi implements CommandLineRunner {

    @Autowired
    private ConsultationBookingRepository exampleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (exampleRepository.count() == 0) {
            ConsultationBookingEntity exampleEntity = new ConsultationBookingEntity();
            exampleEntity.setContent("Initial Document");
            exampleRepository.save(exampleEntity);
        }
    }
}