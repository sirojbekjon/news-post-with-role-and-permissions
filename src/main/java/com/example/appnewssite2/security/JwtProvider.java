package com.example.appnewssite2.security;


import com.example.appnewssite2.entity.Lavozim;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtProvider {

    private static final long expireTime = 1000*60*60*24;
    private static final String secretkey ="MAXFIYSOZHECHKIMBILMASIN";

    public String generateToken(String  username, Lavozim lavozim){
        Date date = new Date(System.currentTimeMillis() + expireTime);
        String token =
                Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(date)
                .claim("roles", lavozim.getName())
                .signWith(SignatureAlgorithm.HS512,secretkey)
                .compact();
        return token;

    }

    public String getUsernameFromToken(String token){
        try{
            String username = Jwts
                    .parser()
                    .setSigningKey(secretkey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            return username;

        }catch (Exception e){
            return null;
        }
    }
}
