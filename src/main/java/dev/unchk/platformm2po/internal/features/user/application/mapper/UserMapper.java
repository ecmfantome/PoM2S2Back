package dev.unchk.platformm2po.internal.features.user.application.mapper;

import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.UserRepositoryEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User mapToUser(UserRequestSignUp userRequestSignUp) {
        return User.builder()
                .email(userRequestSignUp.email())
                .password(userRequestSignUp.password())
                .build();
    }

    public UserRepositoryEntity mapToUserJpa(User user) {
        return UserRepositoryEntity.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
