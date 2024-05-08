package ru.gb.Task_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.Task_service.model.Task;
import ru.gb.Task_service.service.TaskService;
import ru.gb.Task_service.model.Task.TaskStatus;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService service;

    // Добавление задачи
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.add(task);
    }

    // Просмотр всех задач
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    // Просмотр задач по статусу
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.getByStatus(status);
    }

    // Изменение статуса задачи
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
        return service.update(id, task);
    }

    // Удаление задачи
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.delete(id);
    }
}
