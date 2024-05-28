package lk.ijse.gdse66.Backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public interface JWTService {
        String extractUserName(String token);
        String generateToken(UserDetails userDetails);
        boolean isTokenValid(String token, UserDetails userDetails);
}