package dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFirebase {
    public String name;
    public String userId;
    public String lastName;
    public String email;
    public String phone;
    public String role;
    public Boolean isActive;
}
