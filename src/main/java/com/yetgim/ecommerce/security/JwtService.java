package com.yetgim.ecommerce.security;

import com.yetgim.ecommerce.entities.Role;
import com.yetgim.ecommerce.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@Service
public class JwtService {
    @Value("${jwt.key}")
    private String SECRET;

    @Value("${jwt.expiration-ms}")
    private long expirationMillis;


    public String generateToken(UserDetails userDetails){

        HashMap<String,Object> claims = new HashMap<>();

        if (userDetails instanceof User){
            User user = (User)userDetails;
            claims.put("userId",user.getId());
            claims.put("email",user.getEmail());
        }


        List<String> roles = new ArrayList<>();
        for (var role : userDetails.getAuthorities()){
            roles.add(role.getAuthority());
        }

        claims.put("roles",roles);

        String token = createToken(claims, userDetails.getUsername());

        return token;
    }

    public String extractUserName(String token){
        return extractAllClaims(token).getSubject();
    }

    public Date extractExpiration(String token){
        return extractAllClaims(token).getExpiration();
    }



    public  Boolean validateToken(String token, UserDetails userDetails){
        String username = extractAllClaims(token).getSubject();
        Date expiration = extractAllClaims(token).getExpiration();


        return (username.equals(userDetails.getUsername()) && !expiration.before(new Date()));

    }



    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



    private String createToken(Map<String, Object> claims,String subject){

        Date now = new Date();
        return Jwts.builder().
                setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationMillis))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
