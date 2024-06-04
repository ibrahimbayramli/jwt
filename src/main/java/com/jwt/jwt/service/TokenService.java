package com.jwt.jwt.service;

import com.jwt.jwt.dto.TokenRequest;
import com.jwt.jwt.dto.TokenResponse;
import com.jwt.jwt.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final JwtUtil jwtUtil;

    public TokenService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public TokenResponse generateToken(TokenRequest tokenRequest) {
        String token = jwtUtil.generateToken(tokenRequest.getUsername(),tokenRequest.getEmail());
        return new TokenResponse(token);
    }

    public String validateToken(String token) {
        if (jwtUtil.validateToken(token)) {
            return "Token is valid";
        } else {
            return "Token is invalid";
        }
    }
}
