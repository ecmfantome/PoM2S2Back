package dev.unchk.platformm2po.internal.features.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestSignIn {
    private String email;
    private String password;
    @Builder.Default
    private boolean returnSecureToken = true;
}
