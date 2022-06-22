package com.example.appnewssite2.service;

import com.example.appnewssite2.entity.Lavozim;
import com.example.appnewssite2.entity.User;
import com.example.appnewssite2.exceptions.ResourceNotFoundException;
import com.example.appnewssite2.payload.ApiResponce;
import com.example.appnewssite2.payload.RegisterDto;
import com.example.appnewssite2.repository.LavozimRepository;
import com.example.appnewssite2.repository.UserRepository;
import com.example.appnewssite2.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LavozimRepository lavozimRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public ApiResponce registerUser(RegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getPrePassword()))
            return new ApiResponce("Parolllar mos emas", false);
        boolean exists = userRepository.existsByUsername(registerDto.getUsername());
        if (exists){
            return new ApiResponce("Bunday user mavjud",false);
        }
        User user = new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                lavozimRepository.findByName(AppConstants.USER).orElseThrow(()->new ResourceNotFoundException("lavozim","name",AppConstants.USER)),
                true


        );
        userRepository.save(user);
        return new ApiResponce("Muvaffaqqiyatli ro'yxatdan o'tdingiz",true);
        }


    public UserDetails loadUserByUsername(String username) {
       return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }
}
