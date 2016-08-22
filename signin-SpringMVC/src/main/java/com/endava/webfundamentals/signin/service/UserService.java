package com.endava.webfundamentals.signin.service;

import com.endava.webfundamentals.signin.dto.UserRegisterDTO;
import com.endava.webfundamentals.signin.model.User;

import java.util.List;

/**
 * Created by bsoimu on 8/3/2016.
 */

public interface UserService {

        User findByUsername(String username);

        List<User> findAll();

        void save(UserRegisterDTO userRegisterDTO);

}
