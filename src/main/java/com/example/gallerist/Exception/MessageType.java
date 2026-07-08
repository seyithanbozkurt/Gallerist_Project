package com.example.gallerist.Exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXIST("1004", "KAYIT BULUNAMADI"),
    TOKEN_IS_EXPIRED("1005", "TOKEN SURESİ BİTMİŞTİR"),
    USERNAME_NOT_FOUND("1006", "USERNAME NOT FOUND"),
    USERNAME_OR_PASSWORD_ERROR("1007", "USERNAME OR PASSWORD ERROR"),
    GENEREAL_EXCEPTION("9999", "GENEL BİR HATA OLUŞTU");

    private String code;
    private String message;
    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
