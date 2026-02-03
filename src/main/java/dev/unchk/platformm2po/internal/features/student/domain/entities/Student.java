package dev.unchk.platformm2po.internal.features.student.domain.entities;


import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import lombok.Builder;

import java.util.Set;

@Builder
public record Student (String matricule, String anneeEntre, Set<Course> courses) {
}

