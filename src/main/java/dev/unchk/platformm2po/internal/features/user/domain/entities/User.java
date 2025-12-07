package dev.unchk.platformm2po.internal.features.user.domain.entities;

import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import lombok.*;

import java.lang.reflect.Field;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String userId;
    private String lastName;
    private String email;
    private String phone;
    private RoleUser role;
    private Boolean isActive;

    //
    public boolean isEmpty() {
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(this) != null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                System.err.println("[isEmpty User]" + e.getMessage());
            }
        }
        return true;
    }

}
