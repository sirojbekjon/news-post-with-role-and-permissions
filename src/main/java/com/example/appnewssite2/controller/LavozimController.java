package com.example.appnewssite2.controller;


import com.example.appnewssite2.aop.HuquqniTekshirish;
import com.example.appnewssite2.payload.ApiResponce;
import com.example.appnewssite2.payload.LavozimDto;
import com.example.appnewssite2.service.LavozimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lavozim")
public class LavozimController {

    @Autowired
    LavozimService lavozimService;

    @PreAuthorize(value = "hasAuthority('ADD_LAVOZIM')")
    @PostMapping
    public HttpEntity<?> addLavoizm(@Valid @RequestBody LavozimDto lavozimDto){
      ApiResponce apiResponce = lavozimService.addLavozim(lavozimDto);
      return ResponseEntity.status(apiResponce.isSuccess()?200:409).body(apiResponce);
    }
//    @PreAuthorize(value = "hasAuthority('EDIT_LAVOZIM')")
    @HuquqniTekshirish(huquq = "EDIT_LAVOZIM")
    @PutMapping("/{id}")
    public HttpEntity<?> editLavoizm(@PathVariable Long id,@Valid @RequestBody LavozimDto lavozimDto){
      ApiResponce apiResponce = lavozimService.editLavozim(id,lavozimDto);
      return ResponseEntity.status(apiResponce.isSuccess()?200:409).body(apiResponce);
    }
    @HuquqniTekshirish(huquq = "DELETE_LAVOZIM")
    @DeleteMapping ("/{id}")
    public HttpEntity<?> deleteLavoizm(@PathVariable Long id){
      ApiResponce apiResponce = lavozimService.delteLavozim(id);
      return ResponseEntity.status(apiResponce.isSuccess()?200:409).body(apiResponce);
    }
}
