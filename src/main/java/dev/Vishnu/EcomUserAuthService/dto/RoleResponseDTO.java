package dev.Vishnu.EcomUserAuthService.dto;

import dev.Vishnu.EcomUserAuthService.Entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleResponseDTO {
    private String role;
    private String description;

    public static RoleResponseDTO from(Role role) {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setRole(role.getRoleName());
        roleResponseDTO.setDescription(role.getDescription());
        return roleResponseDTO;
    }
}
