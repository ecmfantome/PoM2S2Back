package dev.unchk.platformm2po.internal.features.devoir_rendu.application.dto;

import lombok.Builder;

import java.time.Instant;

@Builder
//Pas la peine de mettre le devoir ici car a la recuperation des devoirs je vais y joindre les devoirs rendu....
public record DevoirRenduResponse(
        String id,
        String description,
        String fileName,
        String contentType,
        byte[] fileContent,
        Instant createdAt,
        Instant updatedAt
) {
}
