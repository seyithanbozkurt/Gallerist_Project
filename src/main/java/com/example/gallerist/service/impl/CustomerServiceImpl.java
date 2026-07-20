package com.example.gallerist.service.impl;

import com.example.gallerist.Exception.BaseException;
import com.example.gallerist.Exception.ErrorMessage;
import com.example.gallerist.Exception.MessageType;
import com.example.gallerist.dto.DtoAccount;
import com.example.gallerist.dto.DtoAddress;
import com.example.gallerist.dto.DtoCustomer;
import com.example.gallerist.dto.DtoCustomerIU;
import com.example.gallerist.model.Account;
import com.example.gallerist.model.Address;
import com.example.gallerist.model.Customer;
import com.example.gallerist.repository.AccountRepository;
import com.example.gallerist.repository.AddresRepository;
import com.example.gallerist.repository.CustomerRepository;
import com.example.gallerist.service.ICustomerService;
import jakarta.persistence.Access;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddresRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
       Optional<Address> optionalAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
        if(optionalAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId().toString()));
        }

        Optional<Account> optionalAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if (optionalAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
        }

        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);

        customer.setAddress(optionalAddress.get());
        customer.setAccount(optionalAccount.get());

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
       DtoCustomer dtoCustomer = new DtoCustomer();
       DtoAddress dtoAddress = new DtoAddress();
       DtoAccount dtoAccount = new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);

        return dtoCustomer;
    }
}
