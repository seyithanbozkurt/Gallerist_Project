package com.example.gallerist.service.impl;

import com.example.gallerist.dto.AuthRequest;
import com.example.gallerist.dto.DtoUser;
import com.example.gallerist.model.User;
import com.example.gallerist.repository.UserRepository;
import com.example.gallerist.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setCreateTime(new Date());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        return user;
    }

    @Override
    public DtoUser register(AuthRequest input) {
        DtoUser dtoUser = new DtoUser();

        User userSaved = userRepository.save(createUser(input));

        BeanUtils.copyProperties(userSaved, dtoUser);

        return dtoUser;
    }
}
