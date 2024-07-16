package com.agriculture_platform.Farm.Management.Repository;

import com.agriculture_platform.Farm.Management.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
