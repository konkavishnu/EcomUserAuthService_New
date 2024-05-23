package dev.Vishnu.EcomUserAuthService.Entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
//NOTE : We are not using '@Data' for getter and setter because it comes along with constructors , which might some times go wrong.
@Getter
@Setter
public abstract class BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id ;
    private boolean isActive; // ---> used to soft delete the profile
    @CreationTimestamp
    private Instant createdAt ;
    @UpdateTimestamp
    private Instant updatedAt;

}