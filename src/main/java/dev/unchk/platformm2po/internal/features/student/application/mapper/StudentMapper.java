package dev.unchk.platformm2po.internal.features.student.application.mapper;

import dev.unchk.platformm2po.internal.features.student.application.dto.StudentUpdateRequest;
import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.student.application.dto.StudentRequest;
import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import dev.unchk.platformm2po.internal.shared.Utils;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;

public class StudentMapper {

    //----------Mapper to entity
    public static Student toEntity(StudentRequest studentRequest) {
        return Student.builder()
                .matricule(Utils.generateRegistrationNumber())
                .anneeEntre(studentRequest.backToSchoolYear())
                .build();
    }

    //----------Mapper to UserRequestSignUp
    public static UserRequestSignUp toUserSignUp(StudentRequest studentRequest, String userId) {
        String roleUser = new RoleUser("STUDENT").getRole();
        return UserRequestSignUp.builder()
                .userId(userId)
                .name(studentRequest.name())
                .lastName(studentRequest.lastName())
                .role(roleUser)
                .phone(studentRequest.phone())
                .email(studentRequest.email())
                .isActive(studentRequest.isActive())
                .build();
    }

    //----------Mapper to UserRequestUpdateClaims
    public static UserRequestUpdateClaims mapToUserRequestUpdateWithNullValues(StudentUpdateRequest source) {
        UserRequestUpdateClaims target = new UserRequestUpdateClaims();
        if (source.userId() != null) {
            target.setUserId(source.userId());
        }
        if (source.name() != null) {
            target.setName(source.name());
        }
        if (source.lastName() != null) {
            target.setLastName(source.lastName());
        }
        if (source.email() != null) {
            target.setEmail(source.email());
        }
        if (source.phone() != null) {
            target.setPhone(source.phone());
        }
        if (source.isActive() != null) {
            target.setIsActive(source.isActive());
        }
        return target;
    }


}
