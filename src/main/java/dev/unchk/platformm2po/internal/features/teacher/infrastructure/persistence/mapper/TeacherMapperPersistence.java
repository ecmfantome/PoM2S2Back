package dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.mapper;

import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;


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
        return Teacher.builder()
                .id(teacherJpa.getId())
                .registration_number(teacherJpa.getRegistration_number())
                .department(teacherJpa.getDepartment())
                .speciality(teacherJpa.getSpeciality())
                .build();
    }
}
