package com.agriculture_platform.Authentication.Repository;

import com.agriculture_platform.Authentication.Entity.Enginner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnginnerRepository extends JpaRepository<Enginner,Long> {
    Optional<Enginner> findByEmail (String email);
}
