package dev.Vishnu.EcomUserAuthService.Service;

import dev.Vishnu.EcomUserAuthService.dto.LoginRequestDTO;
import dev.Vishnu.EcomUserAuthService.dto.SignupRequestDtO;
import dev.Vishnu.EcomUserAuthService.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO signup(SignupRequestDtO signupRequestDtO);

    UserResponseDTO login(LoginRequestDTO loginRequestDTO);

    boolean validateToken(String token);

    boolean logout(String token);
}
