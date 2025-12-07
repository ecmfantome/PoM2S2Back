package dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.repositories;

import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.student.domain.repository.StudentRepository;
import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.entities.StudentJpa;
import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.jpa.StudentRepositoryJpa;
import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.mapper.StudentMapperPersistence;
import dev.unchk.platformm2po.internal.features.student.presentation.exceptions.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.mapper.StudentMapperPersistence.toEntityStudent;


@AllArgsConstructor
@Service
public class StudentRepositoryImpV1 implements StudentRepository {

    private final StudentRepositoryJpa studentRepositoryJpa;

    @Override
    public String saveStudent(Student student) {
        //-----Mapping
        StudentJpa studentJpa = StudentMapperPersistence.toJpa(student);
        //-----Save
        StudentJpa saved = studentRepositoryJpa.save(studentJpa);
        //-----Response
        return saved.getId();
    }

    @Override
    public Student findStudentById(String studentId) {
        Optional<StudentJpa> studentJpa = studentRepositoryJpa.findById(studentId);
        if (studentJpa.isEmpty()) throw new StudentNotFoundException();
        return toEntityStudent(studentJpa.get());
    }

    @Override
    public void deleteStudent(String studentId) {
        boolean isPresent = studentRepositoryJpa.findById(studentId).isPresent();
        if (!isPresent) throw new StudentNotFoundException();
        studentRepositoryJpa.deleteById(studentId);
    }


    @Override
    public void updateBackToSchoolYearStudent(String studentId, String backToSchoolYear) {
        boolean isPresent = studentRepositoryJpa.findById(studentId).isPresent();
        if (!isPresent) throw new StudentNotFoundException();
        int row = studentRepositoryJpa.updateBackToSchoolYear(studentId, backToSchoolYear);
        if (row == 0) throw new RuntimeException();
    }


}
