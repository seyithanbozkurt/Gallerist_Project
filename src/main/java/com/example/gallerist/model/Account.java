package com.example.gallerist.model;

import com.example.gallerist.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

    @Column(name = "account_no")
    private String AccountNo;

    @Column(name = "iban")
    private String iban;

    @Column(name = "amount")
    private BigDecimal amount; //parasal işlmelerde bigdecimal kullanılmalı

    @Column(name = "currencyType")
    @Enumerated(EnumType.STRING)//Strıng olarak seçersek enumda string olarak ne verdiysek db ye o yansır. Orgınal olarak seçersek 0 1 olarak yansır.
    private CurrencyType currencyType;



}
