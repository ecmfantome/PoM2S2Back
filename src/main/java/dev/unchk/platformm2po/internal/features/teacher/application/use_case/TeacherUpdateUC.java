package dev.unchk.platformm2po.internal.features.teacher.application.use_case;

import dev.unchk.platformm2po.internal.features.teacher.application.dto.TeacherUpdateRequest;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.domain.repository.TeacherRepository;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserUpdateClaimsUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static dev.unchk.platformm2po.internal.features.teacher.application.mapper.TeacherMapper.*;


@AllArgsConstructor
@Service
public class TeacherUpdateUC {
    TeacherRepository repository;
    IUserUpdateClaimsUC userUpdateClaimsUC;

    public void execute(TeacherUpdateRequest teacherUpdateRequest) {
        //------Mapping
        Teacher teacher = toEntity(teacherUpdateRequest);
        UserRequestUpdateClaims userRequestUpdateClaims = toUserRequestUpdateClaims(teacherUpdateRequest);
        String userId = userUpdateClaimsUC.execute(userRequestUpdateClaims);
        //------Update teacher
        repository.updateTeacher(userId, teacher);
    }
}
