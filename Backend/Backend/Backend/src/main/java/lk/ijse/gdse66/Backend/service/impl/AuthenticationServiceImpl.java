package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.auth.request.SignInRequest;
import lk.ijse.gdse66.Backend.auth.request.SignUpRequest;
import lk.ijse.gdse66.Backend.auth.response.JWTAuthResponse;
import lk.ijse.gdse66.Backend.service.AuthenticationService;
import lk.ijse.gdse66.Backend.service.JWTService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public JWTAuthResponse signIn(SignInRequest signInRequest) {
        return null;
    }

    @Override
    public JWTAuthResponse signUp(SignUpRequest signUpRequest) {
        return null;
    }

    @Override
    public JWTAuthResponse updateaccount(SignUpRequest signUpRequest) {
        return null;
    }
}
