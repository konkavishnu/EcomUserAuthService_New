package dev.Vishnu.EcomUserAuthService.Repository;

import dev.Vishnu.EcomUserAuthService.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
}
