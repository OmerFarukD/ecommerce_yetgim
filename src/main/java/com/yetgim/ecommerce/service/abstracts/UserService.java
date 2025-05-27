package com.yetgim.ecommerce.service.abstracts;

import com.yetgim.ecommerce.dto.users.RegisterRequestDto;
import com.yetgim.ecommerce.entities.User;

public interface UserService {

    User register (RegisterRequestDto dto);
}
