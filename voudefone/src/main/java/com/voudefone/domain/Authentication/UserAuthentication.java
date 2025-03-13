package com.voudefone.domain.Authentication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



public enum UserAuthentication {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        BASIC,
        ADMIN,
        USER



}

