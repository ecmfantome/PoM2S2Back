package dev.unchk.platformm2po.internal.features.user.domain.value_objects;

import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.UserRoleException;
import dev.unchk.platformm2po.internal.features.user.presentation.custom_labels.CustomLabels;
import lombok.Getter;

@Getter
public class RoleUser {
    private  String role;
    public RoleUser(String role) {
        if (!"STUDENT".equals(role) && !"TEACHER".equals(role) && !"ADMIN".equals(role)) {
            String errorMessage= CustomLabels.getCustomLabels("Fr",CustomLabels.userRoleError);
            throw new UserRoleException(errorMessage);
        }
        this.role = role;
    }
}
