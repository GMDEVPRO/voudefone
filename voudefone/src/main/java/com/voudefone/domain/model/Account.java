package com.voudefone.domain.model;

import com.voudefone.domain.Authentication.UserAuthentication;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.util.List;
@Getter
@Setter
@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "authentication_id")
    private UserAuthentication authentication;  // Usando a nova classe

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskList> taskLists;


}
