package dev.unchk.platformm2po.internal.features.teacher.application.use_case;

import dev.unchk.platformm2po.internal.features.teacher.domain.repository.TeacherRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserDeleteUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TeacherDeleteUC {
    TeacherRepository repository;
    IUserDeleteUC userDeleteUC;

    public void execute(String teacherId) {
        //-----Delete user firebase
        String userId = userDeleteUC.execute(teacherId);
        //-----Delete user database
        repository.deleteTeacher(userId);
    }
}
