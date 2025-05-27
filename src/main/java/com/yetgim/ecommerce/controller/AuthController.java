package com.yetgim.ecommerce.controller;


import com.yetgim.ecommerce.dto.users.LoginRequestDto;
import com.yetgim.ecommerce.service.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto){
        String  response = authService.login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }

}
