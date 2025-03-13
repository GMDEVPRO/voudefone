package com.voudefone.domain.Authentication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_userauthentication")
public class UserAuthentication {  // Renomeado para evitar conflito

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private int loggedInUser;
        private boolean authenticated;


}

