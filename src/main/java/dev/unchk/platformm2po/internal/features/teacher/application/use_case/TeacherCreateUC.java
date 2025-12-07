package dev.unchk.platformm2po.internal.features.teacher.application.use_case;

import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.domain.repository.TeacherRepository;
import dev.unchk.platformm2po.internal.features.teacher.application.dto.TeacherRequest;
import dev.unchk.platformm2po.internal.features.teacher.application.mapper.TeacherMapper;
import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserSignUpUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TeacherCreateUC {
    TeacherRepository repository;
    IUserSignUpUC userSignUpUC;

    public String execute(TeacherRequest teacherRequest) {
        //------Mapping
        Teacher teacher = TeacherMapper.toEntity(teacherRequest);
        //------Save
        String id = repository.saveTeacher(teacher);
        //-----Mapping
        UserRequestSignUp userRequestSignUp = TeacherMapper.toUserSignUp(teacherRequest, id);
        //-----Save user firebase
        userSignUpUC.execute(userRequestSignUp);
        return id;
    }
}
