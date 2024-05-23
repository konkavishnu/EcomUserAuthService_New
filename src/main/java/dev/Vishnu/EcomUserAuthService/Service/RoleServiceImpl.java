package dev.Vishnu.EcomUserAuthService.Service;

import org.springframework.beans.factory.annotation.Autowired;

import dev.Vishnu.EcomUserAuthService.Entity.Role;
import dev.Vishnu.EcomUserAuthService.Repository.RoleRepository;
import dev.Vishnu.EcomUserAuthService.dto.RoleRequestDTO;
import dev.Vishnu.EcomUserAuthService.dto.RoleResponseDTO;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRoleName(roleRequestDTO.getRoleName());
        role.setDescription(roleRequestDTO.getDescription());
        return RoleResponseDTO.from(roleRepository.save(role));
    }

}
