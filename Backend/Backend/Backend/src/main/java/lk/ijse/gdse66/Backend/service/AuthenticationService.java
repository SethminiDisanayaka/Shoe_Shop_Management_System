package lk.ijse.gdse66.Backend.service;

import lk.ijse.gdse66.Backend.auth.request.SignInRequest;
import lk.ijse.gdse66.Backend.auth.request.SignUpRequest;
import lk.ijse.gdse66.Backend.auth.response.JWTAuthResponse;

public interface AuthenticationService {
    JWTAuthResponse signIn(SignInRequest signInRequest);
    JWTAuthResponse signUp(SignUpRequest signUpRequest);
    JWTAuthResponse updateaccount(SignUpRequest signUpRequest);
}
