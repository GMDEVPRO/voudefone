package com.voudefone.domain.service.impl;

import com.voudefone.domain.model.User;
import com.voudefone.domain.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsById(Long.valueOf(userToCreate.getAccount().getEmail()))) {
            throw new IllegalArgumentException("this user email is already exist.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public ResponseEntity<Object> delete(User userDelete) {
        // Verifica se o usuário existe no banco
        if (!userRepository.existsById(Long.valueOf(userDelete.getAccount().getEmail()))) {
            // Se o usuário não for encontrado, lança uma exceção
            throw new IllegalArgumentException("User with email " + userDelete.getAccount().getEmail() + " not found.");
        }

        // Se o usuário existir, realiza a exclusão
        userRepository.delete(userDelete);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content para indicar sucesso
    }



}