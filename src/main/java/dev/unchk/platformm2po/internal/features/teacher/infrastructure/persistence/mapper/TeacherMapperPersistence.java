package dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.mapper;

import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;

import java.util.HashSet;
import java.util.Set;

import static dev.unchk.platformm2po.internal.features.courses.persistence.mapper.CourseMapperPersistence.toCourse;


public class TeacherMapperPersistence {
    //----------Mapper to entity jpa
    public static TeacherJpa toJpa(Teacher teacher) {
        return TeacherJpa.builder()
                .registration_number(teacher.registration_number())
                .department(teacher.department())
                .speciality(teacher.speciality())
                .build();
    }

    //----------Mapper to entity
    public static Teacher toEntityTeacher(TeacherJpa teacherJpa) {
        Set<Course> courses = new HashSet<>();

        if (!teacherJpa.getCourses().stream().toList().isEmpty()) {
            for (CourseJpa courseJpa : teacherJpa.getCourses()) {
                courses.add(toCourse(courseJpa));
            }
        }
        return Teacher.builder()
                .id(teacherJpa.getId())
                .registration_number(teacherJpa.getRegistration_number())
                .department(teacherJpa.getDepartment())
                .speciality(teacherJpa.getSpeciality())
                .courses(courses)
                .build();
    }
}
