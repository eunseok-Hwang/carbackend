package com.carbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Getter
@AllArgsConstructor
@ToString
@EnableLoadTimeWeaving
public class AccountCredentials {
    private String userId;
    private String password;
}
