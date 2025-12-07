package dev.unchk.platformm2po.internal.features.student.application.use_case;

import dev.unchk.platformm2po.internal.features.student.domain.repository.StudentRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserDeleteUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class StudentDeleteUC {
    StudentRepository repository;
    IUserDeleteUC userDeleteUC;

    public void execute(String studentId) {
        String userId = userDeleteUC.execute(studentId);
        //------Delete
        repository.deleteStudent(userId);
    }
}
