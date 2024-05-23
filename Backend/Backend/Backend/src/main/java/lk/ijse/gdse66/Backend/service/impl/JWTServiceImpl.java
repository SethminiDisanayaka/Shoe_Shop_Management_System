package lk.ijse.gdse66.Backend.service.impl;

import lk.ijse.gdse66.Backend.service.JWTService;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTServiceImpl implements JWTService {
    @Override
    public String extractUserName(String token) {
        return null;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return null;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }
}
