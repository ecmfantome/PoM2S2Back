package dev.unchk.platformm2po.internal.features.user.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class User{
    private String email;
    private String password;
}
