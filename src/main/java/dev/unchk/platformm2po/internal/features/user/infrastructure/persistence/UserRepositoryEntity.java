package dev.unchk.platformm2po.internal.features.user.infrastructure.persistence;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class UserRepositoryEntity{
    private String email;
    private String password;
}
