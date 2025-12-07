package dev.unchk.platformm2po.internal.features.user.application.mapper;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.user.application.dto.*;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;
import org.springframework.stereotype.Service;

import java.util.Map;

import static dev.unchk.platformm2po.internal.shared.constant.Constants.*;

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

    public static UserLoginResponse mapToUserLoginResponse(Map<String, Object> stringObjectMap) {
        TokenFirebaseResponse tokenFirebaseResponse = (TokenFirebaseResponse) stringObjectMap.get("token");
        Map<String, Object> claims = (Map<String, Object>) stringObjectMap.get("claims");
        UserProfileResponse userProfileResponse = null;
        String role = claims.get(CLAIM_ROLE).toString();
        String accountId = claims.get(CLAIM_USER_ID).toString();
        userProfileResponse = switch (role) {
            case "STUDENT" -> mapToStudentProfileResponse((Student) stringObjectMap.get("profile"), accountId);
            case "TEACHER" -> mapToTeacherProfileResponse((Teacher) stringObjectMap.get("profile"), accountId);
            case "ADMIN" -> mapToAdminProfileResponse((Admin) stringObjectMap.get("profile"), accountId);
            default -> userProfileResponse;
        };
        return UserLoginResponse.builder()
                .userId(tokenFirebaseResponse.localId())
                .name(claims.get(CLAIM_NAME).toString())
                .lastName(claims.get(CLAIM_LASTNAME).toString())
                .email(claims.get(CLAIM_MAIL).toString())
                .phone(claims.get(CLAIM_PHONE).toString())
                .role(role)
                .isActive((Boolean) claims.get(CLAIM_IS_ACTIVE))
                .token(tokenFirebaseResponse)
                .profile(userProfileResponse)
                .build();

    }

    private static AdminProfileResponse mapToAdminProfileResponse(Admin admin, String accountId) {
        return AdminProfileResponse.builder()
                .adminId(accountId)
                .role(admin.post())
                .build();

    }

    private static TeacherProfileResponse mapToTeacherProfileResponse(Teacher teacher, String accountId) {
        return TeacherProfileResponse.builder()
                .teacherId(accountId)
                .department(teacher.department())
                .registrationNumber(teacher.registration_number())
                .speciality(teacher.speciality())
                .build();

    }

    private static StudentProfileResponse mapToStudentProfileResponse(Student student, String accountId) {
        return StudentProfileResponse.builder()
                .studentId(accountId)
                .backToYearSchool(student.anneeEntre())
                .registrationNumber(student.matricule())
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
