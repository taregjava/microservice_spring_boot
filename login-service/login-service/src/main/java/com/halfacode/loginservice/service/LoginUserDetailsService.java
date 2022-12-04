package com.halfacode.loginservice.service;

import com.halfacode.loginservice.repo.UserAuthRepository;
import com.halfacode.loginservice.model.LoginUserDetails;
import com.halfacode.loginservice.model.UserAuth;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@Service
public class LoginUserDetailsService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserAuth userDb= userAuthRepository.findByUserName(username).orElseThrow(() -> new RuntimeException("User Not found"));
        return new LoginUserDetails(userDb);
    }


}
