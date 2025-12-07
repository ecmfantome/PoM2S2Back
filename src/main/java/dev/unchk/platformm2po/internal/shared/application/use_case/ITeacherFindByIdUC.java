package dev.unchk.platformm2po.internal.shared.application.use_case;

import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;

public interface ITeacherFindByIdUC {
    Teacher execute(String teacherId);
}
