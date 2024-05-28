package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.auth.request.SignInRequest;
import lk.ijse.gdse66.Backend.auth.request.SignUpRequest;
import lk.ijse.gdse66.Backend.auth.response.JWTAuthResponse;
import lk.ijse.gdse66.Backend.dto.UserDTO;
import lk.ijse.gdse66.Backend.enttity.UserEntity;
import lk.ijse.gdse66.Backend.repository.EmployeeRepository;
import lk.ijse.gdse66.Backend.repository.SecurityRepository;
import lk.ijse.gdse66.Backend.service.AuthenticationService;
import lk.ijse.gdse66.Backend.service.JWTService;
import lk.ijse.gdse66.Backend.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final SecurityRepository securityRepository;
    private final ModelMapper mapper;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    EmployeeRepository employeeRepository;

    @Override
    public JWTAuthResponse signIn(SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
        UserEntity user = securityRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        String generatedToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse signUp(SignUpRequest signUpRequest) {
        UserDTO userDTO = UserDTO.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(signUpRequest.getRole())
                .build();
        UserEntity savedUser = securityRepository.save(mapper.map(userDTO, UserEntity.class));
        String generatedToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }

    @Override
    public JWTAuthResponse updateaccount(SignUpRequest signUpRequest) {
        if(!employeeRepository.existsByEmployeeCode(signUpRequest.getEmail())){
            throw new NotFoundException("User"+ signUpRequest.getEmail() + "Not Found...");
        }
        UserDTO userDTO = UserDTO.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(signUpRequest.getRole())
                .build();
        UserEntity savedUser = securityRepository.save(mapper.map(userDTO, UserEntity.class));
        String generatedToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }
}
