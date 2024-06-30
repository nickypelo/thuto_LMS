package com.nicodemus.thuto.service;

import jakarta.mail.internet.MimeMessage;
import lombok.Getter;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("activate_account");

    private final String name;

    EmailTemplateName(String name){
        this.name = name;
    }

}
