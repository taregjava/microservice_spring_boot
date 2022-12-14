package com.halfacode.loginservice.resources;

import com.halfacode.loginservice.config.JwtHelper;
import com.halfacode.loginservice.model.AuthRequest;
import com.halfacode.loginservice.model.AuthResponse;
import com.halfacode.loginservice.service.LoginUserDetailsService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Data
@RestController
//@RequestMapping("/auth")
public class LoginResource {


    private final AuthenticationManager authenticationManager;
    private final LoginUserDetailsService loginUserDetailsService;
    private final JwtHelper jwtHelper;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest){
        try {
            final Authentication authentication=
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
                    );
        }catch (AuthenticationException e){
            throw new RuntimeException(e.getMessage());
        }
        final UserDetails userDetails= loginUserDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwtToken= jwtHelper.generateToken(userDetails);
        AuthResponse response= new AuthResponse();
        response.setJwt(jwtToken);
        return ResponseEntity.ok(response);
    }
   /* @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {

        return loginUserDetailsService.refresh(req.getRemoteUser());
    }
*/
}
