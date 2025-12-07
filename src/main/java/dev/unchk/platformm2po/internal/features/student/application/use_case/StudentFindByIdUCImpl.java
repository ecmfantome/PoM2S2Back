package dev.unchk.platformm2po.internal.features.student.application.use_case;

import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.student.domain.repository.StudentRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.IStudentFindByIdUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class StudentFindByIdUCImpl implements IStudentFindByIdUC {
    StudentRepository repository;

    public Student execute(String studentID) {
        return repository.findStudentById(studentID);
    }
}
