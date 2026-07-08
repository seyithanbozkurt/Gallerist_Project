package com.example.gallerist.controller.impl;

import com.example.gallerist.controller.IRestAuthenticationController;
import com.example.gallerist.controller.RestBaseController;
import com.example.gallerist.controller.RootEntity;
import com.example.gallerist.dto.AuthRequest;
import com.example.gallerist.dto.DtoUser;
import com.example.gallerist.service.IAuthenticationService;
import com.example.gallerist.service.impl.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationController extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.register(authRequest));
    }
}
