package com.agriculture_platform.Farm.Management.Controller;

import com.agriculture_platform.Farm.Management.Entity.Task;
import com.agriculture_platform.Farm.Management.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Endpoint to add a new task
    @PostMapping("/add")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task newTask = taskService.addTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    // Endpoint to update task status
    @PutMapping("/{taskId}/updateStatus")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long taskId,
            @RequestParam String newStatus) {
        Task updatedTask = taskService.updateTaskStatus(taskId, newStatus);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // Endpoint to extend due date of a task
    @PutMapping("/{taskId}/extendDueDate")
    public ResponseEntity<Task> extendDueDate(
            @PathVariable Long taskId,
            @RequestParam Date newDueDate) {
        Task extendedTask = taskService.extendDueDate(taskId, newDueDate);
        return new ResponseEntity<>(extendedTask, HttpStatus.OK);
    }
}
