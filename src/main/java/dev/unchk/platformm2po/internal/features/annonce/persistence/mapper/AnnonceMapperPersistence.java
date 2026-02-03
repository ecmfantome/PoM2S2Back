package dev.unchk.platformm2po.internal.features.annonce.persistence.mapper;

import dev.unchk.platformm2po.internal.features.annonce.persistence.entities.AnnonceJpa;
import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.annonce.domain.entities.Annonce;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.courses.persistence.mapper.CourseMapperPersistence.toCourse;

public class AnnonceMapperPersistence {
    //----------Mapper to entity jpa
    public static List<AnnonceJpa> toAnnoncesJpa(List<Annonce> annonces) {
        return annonces.stream().map(AnnonceMapperPersistence::toAnnonceJpa
        ).toList();
    }

    public static AnnonceJpa toAnnonceJpa(Annonce annonce) {
        CourseJpa courseJpa = CourseJpa.builder().id(annonce.getCourse().getId()).build();
        return AnnonceJpa.builder()
                .titre(annonce.getTitre())
                .message(annonce.getMessage())
                .datePublication(annonce.getDatePublication())
                .type(annonce.getType())
                .courseJpa(courseJpa)
                .build();
    }


    //----------Mapper to entity domain
    public static List<Annonce> toAnnonces(List<AnnonceJpa> annonces) {
        return annonces.stream().map(AnnonceMapperPersistence::toAnnonce).toList();
    }

    //----------Mapper to entity domain
    public static Annonce toAnnonce(AnnonceJpa annonceJpa) {
        Annonce annonce = Annonce.builder()
                .id(annonceJpa.getId())
                .titre(annonceJpa.getTitre())
                .message(annonceJpa.getMessage())
                .datePublication(annonceJpa.getDatePublication())
                .type(annonceJpa.getType())
                .createdAt(annonceJpa.getCreatedAt())
                .updatedAt(annonceJpa.getUpdatedAt())
                .build();
        if (annonceJpa.getCourseJpa() != null && annonceJpa.getCourseJpa().getId() != null) {
            annonce.setCourse(toCourse(annonceJpa.getCourseJpa()));
        }
        return annonce;
    }
}
