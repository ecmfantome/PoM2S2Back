package dev.unchk.platformm2po.internal.shared.application.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequestSignUp  {
    private String userId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private Boolean isActive;
}



