package com.proyecto.abogado.security.auth;

import com.proyecto.abogado.dto.AuthRequest;
import com.proyecto.abogado.dto.AuthResponse;
import com.proyecto.abogado.model.UserModel;
import com.proyecto.abogado.repository.UserRepository;
import com.proyecto.abogado.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse authentication(AuthRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getDni(),
                        request.getPassword())
        );
        UserModel authUser = userRepository.findByDni(request.getDni())
                .orElseThrow();
        String role = String.valueOf(userRepository.findRoleByDni(request.getDni()).getRole());
        String jwtToken = jwtService.generateTokenWithRole(authUser, role);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}