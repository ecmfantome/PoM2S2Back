package dev.unchk.platformm2po.internal.features.student.domain.entities;


import lombok.Builder;

@Builder
public record Student (String matricule,String anneeEntre) {
}

