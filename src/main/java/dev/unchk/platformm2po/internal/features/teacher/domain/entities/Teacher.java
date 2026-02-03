package dev.unchk.platformm2po.internal.features.teacher.domain.entities;


import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import lombok.Builder;

import java.util.Set;

@Builder
public record Teacher (String id , String registration_number , String speciality, String department,
                       Set<Course> courses) {
}