package dev.unchk.platformm2po.internal.features.teacher.application.mapper;

import dev.unchk.platformm2po.internal.features.student.application.dto.StudentRequest;
import dev.unchk.platformm2po.internal.features.teacher.application.dto.TeacherRequest;
import dev.unchk.platformm2po.internal.features.teacher.application.dto.TeacherUpdateRequest;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import dev.unchk.platformm2po.internal.shared.Utils;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;

public class TeacherMapper {

    //----------Mapper to entity
    public static Teacher toEntity(TeacherRequest teacherRequest) {
        return Teacher.builder()
                .registration_number(Utils.generateRegistrationNumber())
                .department(teacherRequest.department())
                .speciality(teacherRequest.speciality())
                .build();
    }

    public static Teacher toEntity(TeacherUpdateRequest teacherUpdateRequest) {
        return Teacher.builder()
                .registration_number(Utils.generateRegistrationNumber())
                .department(teacherUpdateRequest.department())
                .speciality(teacherUpdateRequest.speciality())
                .build();
    }

    //----------Mapper to UserRequestSignUp
    public static UserRequestSignUp toUserSignUp(TeacherRequest teacherRequest, String userId) {
        String roleUser = new RoleUser("TEACHER").getRole();
        return UserRequestSignUp.builder()
                .userId(userId)
                .name(teacherRequest.name())
                .lastName(teacherRequest.lastName())
                .role(roleUser)
                .phone(teacherRequest.phone())
                .email(teacherRequest.email())
                .isActive(teacherRequest.isActive())
                .build();
    }
    //----------Mapper to toUserRequestUpdateClaims
    public static UserRequestUpdateClaims toUserRequestUpdateClaims(TeacherUpdateRequest teacherUpdateRequest) {
        return UserRequestUpdateClaims.builder()
                .userId(teacherUpdateRequest.userId())
                .name(teacherUpdateRequest.name())
                .lastName(teacherUpdateRequest.lastName())
                .phone(teacherUpdateRequest.phone())
                .email(teacherUpdateRequest.email())
                .isActive(teacherUpdateRequest.isActive())
                .build();
    }

}
