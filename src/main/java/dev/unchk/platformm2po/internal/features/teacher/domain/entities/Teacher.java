package dev.unchk.platformm2po.internal.features.teacher.domain.entities;


import lombok.Builder;

@Builder
public record Teacher (String registration_number ,String speciality,String department) {
}