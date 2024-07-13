package com.agriculture_platform.Consulation.Management.Repository;

import com.agriculture_platform.Consulation.Management.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);

}
