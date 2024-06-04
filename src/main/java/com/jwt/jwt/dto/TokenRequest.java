package com.jwt.jwt.dto;

import lombok.Data;

@Data
public class TokenRequest {
    private String username;
    private String email;
}
