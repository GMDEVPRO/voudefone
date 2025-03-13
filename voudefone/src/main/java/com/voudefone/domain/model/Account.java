package com.voudefone.domain.model;
import com.voudefone.domain.Authentication.UserAuthentication;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
    @Getter
    @Setter
    @Entity(name = "tb_account")
    public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @NotNull(message = "O e-mail não pode ser nulo")
        private String email;

        @NotNull(message = "A senha não pode ser nula")
        private String password;

        @Enumerated(EnumType.STRING)
        private UserAuthentication authentication;

        @OneToMany(mappedBy = "account")
        private List<TaskList> taskLists;


    }

