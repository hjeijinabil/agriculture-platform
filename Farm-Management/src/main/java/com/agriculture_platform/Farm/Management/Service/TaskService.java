package com.agriculture_platform.Farm.Management.Service;

import com.agriculture_platform.Farm.Management.Entity.Task;
import com.agriculture_platform.Farm.Management.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // Method to add a new task
    public Task addTask(Task task) {
        // You can add additional logic here if needed
        return taskRepository.save(task);
    }

    // Method to update task status
    public Task updateTaskStatus(Long taskId, String newStatus) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setTaskstatus(newStatus);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task with ID " + taskId + " not found");
        }
    }

    // Method to extend due date of a task
    public Task extendDueDate(Long taskId, Date newDueDate) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setDueDate(newDueDate);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Task with ID " + taskId + " not found");
        }
    }
}
