package dev.unchk.platformm2po.internal.features.teacher.domain.repository;

import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;

public interface TeacherRepository {
    String saveTeacher(Teacher teacher);

    void deleteTeacher(String teacherId);

    Teacher findTeacherById(String teacherId);

    void updateTeacher(String teacherId, Teacher teacher);
}
