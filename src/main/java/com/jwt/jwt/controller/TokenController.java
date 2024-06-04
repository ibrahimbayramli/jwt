package com.jwt.jwt.controller;

import com.jwt.jwt.dto.TokenRequest;
import com.jwt.jwt.dto.TokenResponse;
import com.jwt.jwt.dto.TokenValidateRequest;
import com.jwt.jwt.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }
    @Operation(summary = "Token üretmek için kullanılıyor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token generated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TokenResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @PostMapping("/generate")
    public ResponseEntity<TokenResponse> generateToken(@RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(tokenService.generateToken(tokenRequest));
    }

    @Operation(summary = "Üretilen token doğrulamak için kullanılıyor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token is valid",
                    content = @Content),
            @ApiResponse(responseCode = "401", description = "Invalid token",
                    content = @Content)
    })
    @PostMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestBody TokenValidateRequest tokenValidateRequest) {
        return ResponseEntity.ok(tokenService.validateToken(tokenValidateRequest.getToken()));
    }
}
