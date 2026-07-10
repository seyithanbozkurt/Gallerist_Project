package com.example.gallerist.controller.impl;

import com.example.gallerist.controller.RestAddresController;
import com.example.gallerist.controller.RestBaseController;
import com.example.gallerist.controller.RootEntity;
import com.example.gallerist.dto.DtoAddresIU;
import com.example.gallerist.dto.DtoAddress;
import com.example.gallerist.service.impl.AddresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressController extends RestBaseController implements RestAddresController {

    @Autowired
    private AddresService addresService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddresIU dtoAddressIU) {
        return RootEntity.ok(addresService.saveAddress(dtoAddressIU));
    }
}
