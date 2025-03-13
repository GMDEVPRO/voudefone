package com.voudefone.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity(name = "tb_task")
public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int taskId;
        private String title;
        private String description;

        @Column(name = "due_date", nullable = false)
        private LocalDateTime dueDate;

        private String status;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "task_list_id")
        private TaskList taskList;





}

