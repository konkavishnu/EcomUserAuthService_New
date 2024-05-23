package dev.Vishnu.EcomUserAuthService.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import dev.Vishnu.EcomUserAuthService.Exception.InvalidCredentialExeception;
import dev.Vishnu.EcomUserAuthService.Exception.RoleNotFoundException;
import dev.Vishnu.EcomUserAuthService.Entity.Role;
import dev.Vishnu.EcomUserAuthService.Entity.User;
import dev.Vishnu.EcomUserAuthService.Repository.RoleRepository;
import dev.Vishnu.EcomUserAuthService.Repository.UserRepository;
import dev.Vishnu.EcomUserAuthService.dto.LoginRequestDTO;
import dev.Vishnu.EcomUserAuthService.dto.SignupRequestDtO;
import dev.Vishnu.EcomUserAuthService.dto.UserResponseDTO;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponseDTO signup(SignupRequestDtO signupRequestDtO) throws RoleNotFoundException {

        Role role = roleRepository.findById(signupRequestDtO.getRoleId()).orElseThrow(
                () -> new RoleNotFoundException("Role Not Found"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(signupRequestDtO.getName());
        user.setEmail(signupRequestDtO.getEmail());
        user.setPassword(encoder.encode(signupRequestDtO.getPassword()));
        user.setRoles(List.of(role));
        return UserResponseDTO.from(userRepository.save(user));

    }

    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) throws UsernameNotFoundException {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User savedUser = userRepository.findByEmailId(loginRequestDTO.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found"));

        if (savedUser.getPassword().matches(loginRequestDTO.getPassword())) {

            String userData = savedUser.getEmail() + savedUser.getPassword() + LocalDateTime.now();
            String token = bCryptPasswordEncoder.encode(userData);
            savedUser.setToken(token);
        } else {
            throw new InvalidCredentialExeception();
        }

        savedUser = userRepository.save(savedUser);
        return UserResponseDTO.from(savedUser);

    }

    @Override
    public boolean validateToken(String token) throws InvalidCredentialExeception {

        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialExeception("Invalid Token"));
        return true;
    }

    @Override
    public boolean logout(String token) {

        User savedUser = userRepository.findByToken(token).orElseThrow(
                () -> new InvalidCredentialExeception("Invalid Token"));

        savedUser.setToken(null);
        userRepository.save(savedUser);
        return true;
    }

}
