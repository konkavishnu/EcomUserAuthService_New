package dev.Vishnu.EcomUserAuthService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.Vishnu.EcomUserAuthService.Service.RoleService;
import dev.Vishnu.EcomUserAuthService.dto.RoleRequestDTO;
import dev.Vishnu.EcomUserAuthService.dto.RoleResponseDTO;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    public ResponseEntity<RoleResponseDTO> createRole(@RequestBody RoleRequestDTO roleRequestDTO) {

        return ResponseEntity.ok(roleService.createRole(roleRequestDTO));
    }

}
