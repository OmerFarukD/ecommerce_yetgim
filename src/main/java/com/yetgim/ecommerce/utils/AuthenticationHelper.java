package com.yetgim.ecommerce.utils;

import com.yetgim.ecommerce.entities.User;
import com.yetgim.ecommerce.exceptions.types.BusinessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationHelper {


    public static  String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()){
            throw new BusinessException("Kullanıcı kimlik doğrulayamadı.");
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails){
          String username =  ((UserDetails)principal).getUsername();
        return username;
        }
        throw new BusinessException("Kullanıcı kimlik doğrulayamadı.");
    }



    public static Long getUserId(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()){
            throw new BusinessException("Kullanıcı kimlik doğrulayamadı.");
        }
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails){
            UserDetails details =  ((UserDetails)principal);
            User user = (User)details;
            return user.getId();
        }

        return null;
    }

}
