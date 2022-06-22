package com.example.appnewssite2.controller;


import com.example.appnewssite2.payload.ApiResponce;
import com.example.appnewssite2.payload.UserDto;
import com.example.appnewssite2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public HttpEntity<?> registerUser(@Valid @RequestBody UserDto userDto){
      ApiResponce apiResponce = userService.addUser(userDto);
      return ResponseEntity.status(apiResponce.isSuccess()?200:409).body(apiResponce);
    }
}
