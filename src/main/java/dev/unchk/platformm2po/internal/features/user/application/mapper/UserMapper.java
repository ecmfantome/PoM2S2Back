package dev.unchk.platformm2po.internal.features.user.application.mapper;

import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.entities.UserFirebase;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public static User mapToUser(UserRequestSignUp userRequest) {
        return User.builder()
                .userId(userRequest.getUserId())
                .name(userRequest.getName())
                .lastName(userRequest.getLastName())
                .phone(userRequest.getPhone())
                .role(new RoleUser(userRequest.getRole()))
                .email(userRequest.getEmail())
                .isActive(userRequest.getIsActive())
                .build();
    }

    public static User mapToUserWithNullValues(UserRequestUpdateClaims source) {
        User target = new User();
        if (source.getUserId() != null) {
            target.setUserId(source.getUserId());
        }
        if (source.getName() != null) {
            target.setName(source.getName());
        }
        if (source.getLastName() != null) {
            target.setLastName(source.getLastName());
        }
        if (source.getRole() != null) {
            target.setRole(new RoleUser(source.getRole()));
        }
        if (source.getEmail() != null) {
            target.setEmail(source.getEmail());
        }
        if (source.getPhone() != null) {
            target.setPhone(source.getPhone());
        }
        if (source.getIsActive() != null) {
            target.setIsActive(source.getIsActive());
        }
        return target;
    }

}
