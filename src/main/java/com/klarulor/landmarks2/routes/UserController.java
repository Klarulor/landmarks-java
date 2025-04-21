package com.klarulor.landmarks2.routes;

import com.klarulor.landmarks2.dto.UserRouteRegisterRequestDTO;
import com.klarulor.landmarks2.dto.UserRouteRegisterResponseDTO;
import com.klarulor.landmarks2.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public UserRouteRegisterResponseDTO register(@RequestBody UserRouteRegisterRequestDTO userRouteLoginRequestDTO) {
        UserRouteRegisterResponseDTO responseDTO = new UserRouteRegisterResponseDTO();

        User user = new User();
        user.setUsername(userRouteLoginRequestDTO.login);
        user.setEmail(userRouteLoginRequestDTO.email);
        String hash = passwordEncoder.encode(userRouteLoginRequestDTO.rawPassword);
        user.setPasswordHash(hash);
        

        return responseDTO;
    }
}
