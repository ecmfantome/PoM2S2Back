package dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.mapper;

import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.entities.StudentJpa;

import java.util.HashSet;
import java.util.Set;

import static dev.unchk.platformm2po.internal.features.courses.persistence.mapper.CourseMapperPersistence.toCourse;


public class StudentMapperPersistence {
    //----------Mapper to entity jpa
    public static StudentJpa toJpa(Student student) {
        return StudentJpa.builder()
                .matricule(student.matricule())
                .anneeEntre(student.anneeEntre())
                .build();
    }

    //----------Mapper to entity
    public static Student toEntityStudent(StudentJpa studentJpa) {
        Set<Course> courses = new HashSet<>();

        if (!studentJpa.getCourses().stream().toList().isEmpty()) {
            for (CourseJpa courseJpa : studentJpa.getCourses()) {
                courses.add(toCourse(courseJpa));
            }
        }
        Student student = Student.builder()
                .matricule(studentJpa.getMatricule())
                .anneeEntre(studentJpa.getAnneeEntre())
                .courses(courses)
                .build();
        return  student;
    }
}
