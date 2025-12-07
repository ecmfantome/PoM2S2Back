package dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.mapper;

import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.entities.UserFirebase;
import org.springframework.stereotype.Service;

@Service
public class UserMapperInfrastructure {

    public static UserFirebase mapToUserFirebase(User user) {
        return UserFirebase.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .lastName(user.getLastName())
                .role(user.getRole().getRole())
                .email(user.getEmail())
                .phone(user.getPhone())
                .isActive(user.getIsActive())
                .build();
    }

    public static UserFirebase mapToUserFirebaseWithNullValues(User source) {
        UserFirebase target = new UserFirebase();
        if (source.getUserId() != null) {
            target.userId = source.getUserId();
        }
        if (source.getName() != null) {
            target.name = source.getName();
        }
        if (source.getLastName() != null) {
            target.lastName = source.getLastName();
        }
        if (source.getRole() != null && source.getRole().getRole() != null) {
            target.role = source.getRole().getRole();
        }
        if (source.getEmail() != null) {
            target.email = source.getEmail();
        }
        if (source.getPhone() != null) {
            target.phone = source.getPhone();
        }
        if (source.getIsActive() != null) {
            target.isActive = source.getIsActive();
        }
        return target;
    }

}
