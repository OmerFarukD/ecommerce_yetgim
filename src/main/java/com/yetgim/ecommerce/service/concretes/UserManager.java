package com.yetgim.ecommerce.service.concretes;

import com.yetgim.ecommerce.dto.users.RegisterRequestDto;
import com.yetgim.ecommerce.entities.User;
import com.yetgim.ecommerce.exceptions.types.BusinessException;
import com.yetgim.ecommerce.repository.UserRepository;
import com.yetgim.ecommerce.service.abstracts.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManager  implements UserDetailsService {

    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return  user.orElseThrow(EntityNotFoundException::new);
    }


    public User register(RegisterRequestDto dto) {

        boolean isExistsEmail = userRepository.existsByEmail(dto.email());
        if (isExistsEmail){
            throw new BusinessException("Email alanı benzersiz olmalıdır.");
        }

        boolean isExistUsername = userRepository.existsByUsername(dto.username());

        if (isExistUsername){
            throw new BusinessException("Username alanı benzersiz olmalıdır.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(encoder.encode(dto.password()))
                .build();

      return  this.userRepository.save(user);

    }
}
