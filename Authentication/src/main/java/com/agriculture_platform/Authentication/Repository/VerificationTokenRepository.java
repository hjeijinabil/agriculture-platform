package com.agriculture_platform.Authentication.Repository;

import com.agriculture_platform.Authentication.Entity.VerficationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerficationToken , Long> {
    @Query("SELECT t FROM VerficationToken t WHERE t.token = :token")
    VerficationToken findByTokenQuery(String token);
}
