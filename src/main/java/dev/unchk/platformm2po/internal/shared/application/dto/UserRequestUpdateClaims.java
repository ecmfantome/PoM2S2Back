package dev.unchk.platformm2po.internal.shared.application.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestUpdateClaims  {
    private String userId;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private Boolean isActive;
}
