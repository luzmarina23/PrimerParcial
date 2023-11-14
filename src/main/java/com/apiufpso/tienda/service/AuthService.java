package com.apiufpso.tienda.service;

import com.apiufpso.tienda.auth.AuthResponse;
import com.apiufpso.tienda.auth.LoginRequest;
import com.apiufpso.tienda.auth.RegisterRequest;
import com.apiufpso.tienda.exception.NotFoundException;
import com.apiufpso.tienda.jwt.JwtService;
import com.apiufpso.tienda.model.User;
import com.apiufpso.tienda.repository.UserRepository;
import com.apiufpso.tienda.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        UserDetails user = userRepository.findByEmail(
                request.getEmail()).orElseThrow(
                        () -> new NotFoundException("Credentials incorrect"));
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .document(request.getDocument())
                .phone(request.getPhone())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
