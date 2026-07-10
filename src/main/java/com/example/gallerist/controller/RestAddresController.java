package com.example.gallerist.controller;

import com.example.gallerist.dto.DtoAddresIU;
import com.example.gallerist.dto.DtoAddress;

public interface RestAddresController {

    public RootEntity<DtoAddress> saveAddress(DtoAddresIU dtoAddressIU);
}
