package dev.Vishnu.EcomUserAuthService.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ECOM_USER") // here we are metioning the name because we will encounter "Reserve Keyword
// issue"
@Getter
@Setter
public class User extends BaseModel {

    private String name;
    private String email;
    private String password;
    private String token;
    @ManyToMany
    private List<Role> roles;

}
