package dev.unchk.platformm2po.internal.features.student.domain.repository;

import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;

public interface StudentRepository {
    String saveStudent(Student student);

    Student findStudentById(String studentId);

    void deleteStudent(String studentId);

    void updateBackToSchoolYearStudent(String studentId, String backToSchoolYear);
}
