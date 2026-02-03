package dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.mapper;

import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.entities.DevoirRendu;
import dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.entities.DevoirRenduJpa;

import java.util.List;

public class DevoirRenduMapperPersistence {
    //----------Mapper to entity jpa
    public static List<DevoirRenduJpa> toDevoirRendusJpa(List<DevoirRendu> devoirs) {
        return devoirs.stream().map(DevoirRenduMapperPersistence::toDevoirRenduJpa
        ).toList();
    }

    public static DevoirRenduJpa toDevoirRenduJpa(DevoirRendu devoir) {
        return DevoirRenduJpa.builder()
                .description(devoir.getDescription())
                .contentType(devoir.getContentType())
                .fileContent(devoir.getFileContent())
                .fileName(devoir.getFileName())
                .build();
    }


    //----------Mapper to entity domain
    public static List<DevoirRendu> toDevoirRendus(List<DevoirRenduJpa> devoirs) {
        return devoirs.stream().map(DevoirRenduMapperPersistence::toDevoirRendu).toList();
    }

    //----------Mapper to entity domain
    public static DevoirRendu toDevoirRendu(DevoirRenduJpa devoirJpa) {
        return DevoirRendu.builder()
                .id(devoirJpa.getId())
                .description(devoirJpa.getDescription())
                .contentType(devoirJpa.getContentType())
                .fileContent(devoirJpa.getFileContent())
                .fileName(devoirJpa.getFileName())
                .createdAt(devoirJpa.getCreatedAt())
                .build();
    }
}
