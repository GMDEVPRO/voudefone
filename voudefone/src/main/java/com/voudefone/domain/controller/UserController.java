package com.voudefone.domain.controller;

import com.voudefone.domain.model.User;
import com.voudefone.domain.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return ResponseEntity.ok(user);
    }




    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userTocreate) {
        // Log para verificar o corpo da requisição
        logger.info("Recebendo requisição para criar o usuário: {}", userTocreate);

        if (userTocreate.getUserName() == null || userTocreate.getAccount().getEmail() == null || userTocreate.getAccount().getPassword() == null) {
            logger.warn("Campos obrigatórios estão ausentes. Requisição inválida.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Retorna erro 400
        }

        User createdUser = userService.create(userTocreate);
        logger.info("Usuário criado com sucesso: {}", createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }



    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody User userDelete) {
        return userService.delete(userDelete);
    }





}
