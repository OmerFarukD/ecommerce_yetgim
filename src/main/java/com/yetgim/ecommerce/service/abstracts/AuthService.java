package com.yetgim.ecommerce.service.abstracts;


import com.yetgim.ecommerce.dto.users.LoginRequestDto;

public interface AuthService {

    String login(LoginRequestDto dto);

}
