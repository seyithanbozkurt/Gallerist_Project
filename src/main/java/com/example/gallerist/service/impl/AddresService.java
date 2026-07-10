package com.example.gallerist.service.impl;

import com.example.gallerist.dto.DtoAddresIU;
import com.example.gallerist.dto.DtoAddress;
import com.example.gallerist.model.Address;
import com.example.gallerist.repository.AddresRepository;
import com.example.gallerist.service.IAddresService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddresService implements IAddresService {

    @Autowired
    private AddresRepository  addresRepository;

    private Address createAddress(DtoAddresIU dtoAddressIU) {
        Address address = new Address();
        address.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoAddressIU, address);

        return address;
    }


    @Override
    public DtoAddress saveAddress(DtoAddresIU dtoAddressIU) {
        DtoAddress dtoAddress = new DtoAddress();

        Address savedAddress = addresRepository.save(createAddress(dtoAddressIU));

        BeanUtils.copyProperties(savedAddress, dtoAddress);

        return dtoAddress;
    }
}
