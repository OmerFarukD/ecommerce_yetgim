package com.yetgim.ecommerce.controller;


import com.yetgim.ecommerce.dto.users.LoginRequestDto;
import com.yetgim.ecommerce.service.abstracts.AuthService;
import com.yetgim.ecommerce.utils.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/current")
    public ResponseEntity<String> getCurrentUser(){
        String username = AuthenticationHelper.getUserName();
        Long id = AuthenticationHelper.getUserId();

        return ResponseEntity.status(HttpStatus.OK).body(username + " Id: "+id);

    }

}
