package com.leetcode2024spring.ecommercedemo1.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

//    @Value("${jwt.secret}")
    private String secret="MzIxNzQ5NDg2MTIxNTA3NTM0MjY1OTIAMzIxNzQ5NDg2MTIxNTA3NTM0MjY1OTIMzIxNzQ5NDg2MTIxNTA3NTM0MjY1OTI";

//    @Value("${jwt.expiration}")
    private int expiration=3600;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);
        System.out.println(secret);
        System.out.println(expiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}

