package com.example.gallerist.Exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXIST("1004", "KAYIT BULUNAMADI"),
    GENEREAL_EXCEPTION("9999", "GENEL BİR HATA OLUŞTU");

    private String code;
    private String message;
    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
