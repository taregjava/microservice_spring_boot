package com.halfacode.loginservice.config;

import com.halfacode.loginservice.model.UserAuth;
import com.halfacode.loginservice.repo.UserAuthRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Data
@Component
//@Profile("Local")
public class LocalDataProvider implements CommandLineRunner {
    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        userAuthRepository.deleteAll();

        UserAuth normalUser= UserAuth.builder()
                .userName("tareg")
                .password(passwordEncoder.encode("0912658511"))
                .roles("ROLE_USER")
                .active(true)
                .build();
        UserAuth adminUser=UserAuth.builder()
                .userName("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ROLE_ADMIN")
                .active(true)
                .build();

        UserAuth inActiveUser=UserAuth.builder()
                .userName("john")
                .password(passwordEncoder.encode("john"))
                .roles("ROLE_ADMIN")
                .active(false)
                .build();

        userAuthRepository.saveAll(Arrays.asList(normalUser,adminUser,inActiveUser));
    }
}
