package ru.gb.Task_service.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Описание задачи
    @Column(name = "description", nullable = false)
    private String description;

    // Статус задачи
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    // Время создания задачи
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    // Тип статуса задачи
    public enum TaskStatus {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED
    }

    // Присвоение задаче текущей даты при создании
    @PrePersist
    public void setCreationDate() {
        this.creationDate = LocalDateTime.now();
    }
}
