package dev.unchk.platformm2po.internal.features.user.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestSignIn {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @Builder.Default
    private boolean returnSecureToken = true;
}
