package dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.mapper;

import dev.unchk.platformm2po.internal.features.student.domain.entities.Student;
import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.entities.StudentJpa;


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
        return Student.builder()
                .matricule(studentJpa.getMatricule())
                .anneeEntre(studentJpa.getAnneeEntre())
                .build();
    }
}
