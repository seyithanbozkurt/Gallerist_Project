package com.example.gallerist.controller;

import com.example.gallerist.dto.AuthRequest;
import com.example.gallerist.dto.AuthResponse;
import com.example.gallerist.dto.DtoUser;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest authRequest);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);
}
