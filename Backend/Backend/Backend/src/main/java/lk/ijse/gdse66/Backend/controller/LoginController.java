package lk.ijse.gdse66.Backend.controller;

import lk.ijse.gdse66.Backend.auth.request.SignInRequest;
import lk.ijse.gdse66.Backend.auth.request.SignUpRequest;
import lk.ijse.gdse66.Backend.auth.response.JWTAuthResponse;
import lk.ijse.gdse66.Backend.service.AuthenticationService;
import lk.ijse.gdse66.Backend.util.CurrentUser;
import lk.ijse.gdse66.Backend.util.ResponseUtil;
import lk.ijse.gdse66.Backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> signIn(
            @RequestBody SignInRequest signInRequest){
        System.out.println("Signing in");
        return ResponseEntity.ok(
                authenticationService.signIn(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<JWTAuthResponse> signUp(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }
    @PostMapping("/signupupdate")
    public ResponseEntity<JWTAuthResponse> signUpdate(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }

}
