package dev.unchk.platformm2po.internal.features.devoir.persistence.mapper;

import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.devoir.domain.entities.Devoir;
import dev.unchk.platformm2po.internal.features.devoir.persistence.entities.DevoirJpa;
import java.util.List;
import static dev.unchk.platformm2po.internal.features.courses.persistence.mapper.CourseMapperPersistence.toCourse;

public class DevoirMapperPersistence {
    //----------Mapper to entity jpa
    public static List<DevoirJpa> toDevoirsJpa(List<Devoir> devoirs) {
        return devoirs.stream().map(DevoirMapperPersistence::toDevoirJpa
        ).toList();
    }

    public static DevoirJpa toDevoirJpa(Devoir devoir) {
        CourseJpa courseJpa = CourseJpa.builder().id(devoir.getCourse().getId()).build();
        return DevoirJpa.builder()
                .titre(devoir.getTitre())
                .consigne(devoir.getConsigne())
                .dateLimite(devoir.getDateLimite())
                .courseJpa(courseJpa)
                .build();
    }


    //----------Mapper to entity domain
    public static List<Devoir> toDevoirs(List<DevoirJpa> devoirs) {
        return devoirs.stream().map(DevoirMapperPersistence::toDevoir).toList();
    }

    //----------Mapper to entity domain
    public static Devoir toDevoir(DevoirJpa devoirJpa) {
        Devoir devoir = Devoir.builder()
                .id(devoirJpa.getId())
                .titre(devoirJpa.getTitre())
                .consigne(devoirJpa.getConsigne())
                .dateLimite(devoirJpa.getDateLimite())
                .createdAt(devoirJpa.getCreatedAt())
                .updatedAt(devoirJpa.getUpdatedAt())
                .build();
        if (devoirJpa.getCourseJpa() != null && devoirJpa.getCourseJpa().getId() != null) {
            devoir.setCourse(toCourse(devoirJpa.getCourseJpa()));
        }
        return devoir;
    }
}
