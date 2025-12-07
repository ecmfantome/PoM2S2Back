package dev.unchk.platformm2po.internal.features.teacher.application.use_case;

import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.domain.repository.TeacherRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.ITeacherFindByIdUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class TeacherFindByIdUCImpl implements ITeacherFindByIdUC {
    TeacherRepository repository;

    public Teacher execute(String teacherId) {
        return repository.findTeacherById(teacherId);
    }
}
