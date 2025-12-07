package dev.unchk.platformm2po.internal.features.student.application.use_case;

import dev.unchk.platformm2po.internal.features.student.application.dto.StudentRequest;
import dev.unchk.platformm2po.internal.features.student.application.mapper.StudentMapper;
import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.student.domain.repository.StudentRepository;
import dev.unchk.platformm2po.internal.features.user.domain.value_objects.RoleUser;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserSignUpUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class StudentCreateUC {
    StudentRepository repository;
    IUserSignUpUC userSignUpUC;

    public String execute(StudentRequest studentRequest) {
        //------Mapping
        Student student = StudentMapper.toEntity(studentRequest);
        //------Save
        String id = repository.saveStudent(student);
        //-----Mapping
        UserRequestSignUp userRequestSignUp = StudentMapper.toUserSignUp(studentRequest, id);
        //-----Save user firebase
        userSignUpUC.execute(userRequestSignUp);
        return id;
    }
}
