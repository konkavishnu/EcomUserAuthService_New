package dev.Vishnu.EcomUserAuthService.dto;

import dev.Vishnu.EcomUserAuthService.Entity.Role;
import dev.Vishnu.EcomUserAuthService.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class UserResponseDTO {

    private String name;
    private String email;
    private List<RoleResponseDTO> roles;
    private String token;

    // the below function is a mapper function where the attributes are mapped from
    // the entity(User, Role) to the DTO

    public static UserResponseDTO from(User user) {
        if (user == null)
            return null;
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.name = user.getName();
        userResponseDTO.email = user.getEmail();
        userResponseDTO.token = user.getToken();
        userResponseDTO.roles = new ArrayList<>();
        for (Role role : user.getRoles()) {
            RoleResponseDTO responseDTO = new RoleResponseDTO();
            responseDTO.setRole(role.getRoleName());
            responseDTO.setDescription(role.getDescription());
            userResponseDTO.roles.add(responseDTO);
        }
        return userResponseDTO;
    }

    public static User from(UserResponseDTO userResponseDTO) {
        return null;
    }

}
