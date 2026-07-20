package com.example.gallerist.service.impl;

import com.example.gallerist.Exception.BaseException;
import com.example.gallerist.Exception.ErrorMessage;
import com.example.gallerist.Exception.MessageType;
import com.example.gallerist.dto.DtoAddress;
import com.example.gallerist.dto.DtoGallerist;
import com.example.gallerist.dto.DtoGalleristIU;
import com.example.gallerist.model.Address;
import com.example.gallerist.model.Gallerist;
import com.example.gallerist.repository.AddresRepository;
import com.example.gallerist.repository.GalleristRepository;
import com.example.gallerist.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristService implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AddresRepository addressRepository;

    private Gallerist createGallerist(DtoGalleristIU dtoGalleristIU) {
        Optional<Address> optinalAddress = addressRepository.findById(dtoGalleristIU.getAddressId());
        if (optinalAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoGalleristIU.getAddressId().toString()));

        }

        Gallerist gallerist = new Gallerist();
        gallerist.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoGalleristIU, gallerist);
        gallerist.setAddress(optinalAddress.get());

        return gallerist;

    }
    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();
         Gallerist saveGallerist =  galleristRepository.save( createGallerist(dtoGalleristIU));

         BeanUtils.copyProperties(saveGallerist,dtoGallerist);
         BeanUtils.copyProperties( saveGallerist.getAddress(),dtoAddress);

         dtoGallerist.setAddress(dtoAddress);
        return dtoGallerist;
    }
}
