package com.voudefone.domain.service.impl;

import com.voudefone.domain.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User findById(Long id);



    User create(User userToCreate);


    ResponseEntity<Object> delete(User userToDelete);


}
