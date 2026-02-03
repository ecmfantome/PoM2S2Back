package dev.unchk.platformm2po.internal.features.courses.persistence.mapper;

import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.entities.AdminJpa;
import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities.ModuleJpa;
import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.entities.StudentJpa;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.mapper.AdminMapperPersistence.toEntityAdmin;
import static dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.mapper.ModuleMapperPersistence.toModule;
import static dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.mapper.StudentMapperPersistence.toEntityStudent;
import static dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.mapper.TeacherMapperPersistence.toEntityTeacher;

public class CourseMapperPersistence {
    //----------Mapper to entity jpa
    public static List<CourseJpa> toCoursesJpa(List<Course> courses) {
        return courses.stream().map(CourseMapperPersistence::toCourseJpa
        ).toList();
    }

    public static CourseJpa toCourseJpa(Course course) {
        AdminJpa adminJpa = AdminJpa.builder().id(course.getCreatedBy().id()).build();
        ModuleJpa moduleJpa = ModuleJpa.builder().id(course.getModule().getId()).build();
        return CourseJpa.builder()
                .titre(course.getTitre())
                .credits(course.getCredit())
                .semester(course.getSemestre())
                .description(course.getDescription())
                .createdBy(adminJpa)
                .moduleJpa(moduleJpa)
                .build();
    }


    //----------Mapper to entity domain
    public static List<Course> toCourses(List<CourseJpa> courses) {
        return courses.stream().map(CourseMapperPersistence::toCourse).toList();
    }

    //----------Mapper to entity domain
    public static Course toCourse(CourseJpa courseJpa) {
        Course course = Course.builder()
                .id(courseJpa.getId())
                .titre(courseJpa.getTitre())
                .description(courseJpa.getDescription())
                .semestre(courseJpa.getSemester())
                .createdBy(toEntityAdmin(courseJpa.getCreatedBy()))
                .createdAt(courseJpa.getCreatedAt())
                .updatedAt(courseJpa.getUpdatedAt())
                .credit(courseJpa.getCredits())
                .build();
        if (!courseJpa.getStudents().stream().toList().isEmpty()) {
             Set<Student> students = new HashSet<>();
            for (StudentJpa studentJpa : courseJpa.getStudents()) {
                students.add(toEntityStudent(studentJpa));
            }
            course.setStudents(students);
        }
        if (!courseJpa.getTeachers().stream().toList().isEmpty()) {
            Set<Teacher> teachers = new HashSet<>();
            for (TeacherJpa teacherJpa : courseJpa.getTeachers()) {
                teachers.add(toEntityTeacher(teacherJpa));
            }
            course.setTeachers(teachers);
        }
        if (courseJpa.getModuleJpa() != null && courseJpa.getModuleJpa().getId() != null) {
            course.setModule(toModule(courseJpa.getModuleJpa()));
        }
        return course;
    }
}
