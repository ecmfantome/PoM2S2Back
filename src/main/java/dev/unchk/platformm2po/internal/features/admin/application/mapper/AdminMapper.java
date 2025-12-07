package dev.unchk.platformm2po.internal.features.admin.application.mapper;


import dev.unchk.platformm2po.internal.features.admin.application.dto.AdminRequest;
import dev.unchk.platformm2po.internal.features.admin.application.dto.AdminUpdateRequest;
import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;

public class AdminMapper {

    //----------Mapper to entity
    public static Admin toEntity(AdminRequest adminRequest) {
        return Admin.builder()
                .post(adminRequest.post())
                .build();
    }

    public static Admin toEntity(AdminUpdateRequest adminUpdateRequest) {
        return Admin.builder()
                .post(adminUpdateRequest.post())
                .build();
    }

    //----------Mapper to UserRequestSignUp
    public static UserRequestSignUp toUserSignUp(AdminRequest adminRequest, String userId) {
        String roleUser = new RoleUser("ADMIN").getRole();
        return UserRequestSignUp.builder()
                .userId(userId)
                .name(adminRequest.name())
                .lastName(adminRequest.lastName())
                .role(roleUser)
                .phone(adminRequest.phone())
                .email(adminRequest.email())
                .isActive(adminRequest.isActive())
                .build();
    }
    //----------Mapper to UserRequestSignUp
    public static UserRequestUpdateClaims toUserRequestUpdateClaims(AdminUpdateRequest adminUpdateRequest) {
        String roleUser = new RoleUser("ADMIN").getRole();
        return UserRequestUpdateClaims.builder()
                .userId(adminUpdateRequest.userId())
                .name(adminUpdateRequest.name())
                .lastName(adminUpdateRequest.lastName())
                .role(roleUser)
                .phone(adminUpdateRequest.phone())
                .email(adminUpdateRequest.email())
                .isActive(adminUpdateRequest.isActive())
                .build();
    }
}
