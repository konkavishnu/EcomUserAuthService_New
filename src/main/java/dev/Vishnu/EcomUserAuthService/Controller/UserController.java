package dev.Vishnu.EcomUserAuthService.Controller;

import dev.Vishnu.EcomUserAuthService.Service.UserService;
import dev.Vishnu.EcomUserAuthService.dto.LoginRequestDTO;
import dev.Vishnu.EcomUserAuthService.dto.SignupRequestDtO;
import dev.Vishnu.EcomUserAuthService.dto.UserResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(userService.login(loginRequestDTO));
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(@RequestHeader("Authorization") String authtoken) {
        return ResponseEntity.ok(userService.logout(authtoken));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@RequestBody SignupRequestDtO signupRequestDtO) {
        return ResponseEntity.ok(userService.signup(signupRequestDtO));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestHeader("Authorization") String authtoken) {
        return ResponseEntity.ok(userService.validateToken(authtoken));
    }

}
