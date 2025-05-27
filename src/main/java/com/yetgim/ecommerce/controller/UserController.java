package com.yetgim.ecommerce.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


/*    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequestDto dto){
        userService.register(dto);
        return ResponseEntity.ok("Kullanıcı Eklendi.");
    }*/
}
