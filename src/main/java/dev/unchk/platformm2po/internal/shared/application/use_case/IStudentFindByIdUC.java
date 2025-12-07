package dev.unchk.platformm2po.internal.shared.application.use_case;

import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;


public interface IStudentFindByIdUC {
     Student execute(String studentId);
}
