package dev.unchk.platformm2po.internal.features.teacher.persistence.mapper;

import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import dev.unchk.platformm2po.internal.features.teacher.persistence.entities.TeacherJpa;


public class TeacherMapperPersistence {
    //----------Mapper to entity jpa
    public static TeacherJpa toJpa(Teacher teacher) {
        return TeacherJpa.builder()
                .registration_number(teacher.registration_number())
                .department(teacher.department())
                .speciality(teacher.speciality())
                .build();
    }
}
