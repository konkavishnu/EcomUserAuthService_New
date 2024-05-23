package dev.Vishnu.EcomUserAuthService.Service;

import dev.Vishnu.EcomUserAuthService.dto.RoleRequestDTO;
import dev.Vishnu.EcomUserAuthService.dto.RoleResponseDTO;

public interface RoleService {

    RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO);

}
