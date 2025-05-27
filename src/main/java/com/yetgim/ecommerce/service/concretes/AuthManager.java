package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.dto.users.LoginRequestDto;
import com.yetgim.ecommerce.entities.User;
import com.yetgim.ecommerce.exceptions.types.NotFoundException;
import com.yetgim.ecommerce.repository.UserRepository;
import com.yetgim.ecommerce.security.JwtService;
import com.yetgim.ecommerce.service.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthManager implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(LoginRequestDto dto) {

        User user = userRepository.findByUsername(dto.username()).orElseThrow(
                ()-> new NotFoundException("Kullanıcı Bulunamadı."));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.username(),
                        dto.password()
                )
        );



        String jwt = jwtService.generateToken(user);

        return jwt;
    }
}
