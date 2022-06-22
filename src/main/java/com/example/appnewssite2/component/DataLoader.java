package com.example.appnewssite2.component;

import com.example.appnewssite2.entity.Lavozim;
import com.example.appnewssite2.entity.User;
import com.example.appnewssite2.entity.enums.Huquq;
import com.example.appnewssite2.repository.LavozimRepository;
import com.example.appnewssite2.repository.UserRepository;
import com.example.appnewssite2.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LavozimRepository lavozimRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${spring.sql.init.mode}")
    private String initialMode;
    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")){
            Huquq[] huquqList = Huquq.values();
            Lavozim admin = lavozimRepository.save(new Lavozim(
                    AppConstants.ADMIN,
                    Arrays.asList(huquqList),
                    "Sistema egasi"

            ));
            Lavozim user = lavozimRepository.save(new Lavozim(
                    AppConstants.USER,
                    Arrays.asList(Huquq.ADD_COMMIT,Huquq.EDIT_COMMENT,Huquq.DELETE_MY_COMMENT),
                    "Oddiy foydalanuvchi"
            ));
            userRepository.save(new User(
                    "Admin",
                    "admin",
                    passwordEncoder.encode("admin123"),
                    admin,
                    true

            ));
            userRepository.save(new User(
                    "User",
                    "user",
                    passwordEncoder.encode("user123"),
                    user,
                    true

            ));
        }

    }
}
