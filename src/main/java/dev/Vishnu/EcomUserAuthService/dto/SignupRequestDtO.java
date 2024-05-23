package dev.Vishnu.EcomUserAuthService.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SignupRequestDtO {

    private String name;
    private String email;
    private String password;
    private UUID roleId;
}
