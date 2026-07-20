package com.example.gallerist.controller.impl;

import com.example.gallerist.controller.IRestGalleristController;
import com.example.gallerist.controller.RestBaseController;
import com.example.gallerist.controller.RootEntity;
import com.example.gallerist.dto.DtoGallerist;
import com.example.gallerist.dto.DtoGalleristIU;
import com.example.gallerist.service.IGalleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristController extends RestBaseController implements IRestGalleristController {

    @Autowired
    private IGalleristService  galleristService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok (galleristService.saveGallerist(dtoGalleristIU));
    }
}
