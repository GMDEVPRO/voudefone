package com.voudefone.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@Entity(name = "tb_tasklist")
public class TaskList {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "account_id")
        private Account account;

        @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Task> tasks;


    }


