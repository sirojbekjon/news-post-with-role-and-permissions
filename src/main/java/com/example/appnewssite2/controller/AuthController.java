package com.example.appnewssite2.controller;


import com.example.appnewssite2.entity.User;
import com.example.appnewssite2.payload.ApiResponce;
import com.example.appnewssite2.payload.LoginDto;
import com.example.appnewssite2.payload.RegisterDto;
import com.example.appnewssite2.security.JwtProvider;
import com.example.appnewssite2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthService authService;

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public HttpEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto){
      ApiResponce apiResponce = authService.registerUser(registerDto);
      return ResponseEntity.status(apiResponce.isSuccess()?200:409).body(apiResponce);
    }
    @PostMapping("/login")
    public HttpEntity<?> loginUser(@Valid @RequestBody LoginDto loginDto){
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
    User user = (User)authentication.getPrincipal();
    String token = jwtProvider.generateToken(user.getUsername(),user.getLavozim());
    return ResponseEntity.ok(token);
    }
}
