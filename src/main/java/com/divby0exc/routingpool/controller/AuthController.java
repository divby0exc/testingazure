package com.divby0exc.routingpool.controller;

import com.divby0exc.routingpool.config.JwtTokenUtil;
import com.divby0exc.routingpool.dto.UserDTO;
import com.divby0exc.routingpool.service.JWTUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JWTUserDetailsService userDetailsService;

    @PostMapping("validate")
    public ResponseEntity<?> validate(@RequestBody JwtRequest authReq)  throws Exception {
        authenticate(authReq.getUsername(), authReq.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity
                .ok(new JwtResponse(token));
    }
    @GetMapping("granted")
    public String tokenAccepted() {

    }
    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity
                .ok(userDetailsService.save(userDTO));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            username, password
                    ));
        }catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
