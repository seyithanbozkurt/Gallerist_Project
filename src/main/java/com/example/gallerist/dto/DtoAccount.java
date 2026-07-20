package com.example.gallerist.dto;

import com.example.gallerist.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoAccount extends DtoBase{

    private String AccountNo;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currencyType;
}
