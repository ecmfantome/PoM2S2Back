package dev.unchk.platformm2po.internal.features.devoir.domain.entities;


import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Devoir {
    private String id;
    private String titre;
    private String consigne;
    private Instant dateLimite;
    private Course course;

    private Instant createdAt;
    private Instant updatedAt;
}
