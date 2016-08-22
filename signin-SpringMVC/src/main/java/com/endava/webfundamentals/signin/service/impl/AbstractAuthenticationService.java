package com.endava.webfundamentals.signin.service.impl;

import com.endava.webfundamentals.signin.dto.UserCredentialDTO;
import com.endava.webfundamentals.signin.model.User;
import com.endava.webfundamentals.signin.repository.UserRepository;
import com.endava.webfundamentals.signin.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Created by fstancu on 7/22/2016.
 */

public abstract class AbstractAuthenticationService implements AuthenticationService {

    protected static final String SESSION = "session";

    @Autowired
    UserRepository userRepository;

    @Value("#{'${users}'.split(',')}")
    protected List<String> users;

    @Value("${password:password}")
    private String password;

    @Override
    public boolean isValid(UserCredentialDTO userCredentialDTO) {
        if(userCredentialDTO == null)
            return false;

        User user = userRepository.findByUsername(userCredentialDTO.getUsername());
        return user.getUsername().equals(userCredentialDTO.getUsername()) &&
                user.getPassword().equals(userCredentialDTO.getPassword());
    }

}
