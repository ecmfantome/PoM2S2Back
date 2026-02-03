package dev.unchk.platformm2po.internal.features.annonce.domain.entities;


import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Annonce {
    private String id;
    private String titre;
    private String message;
    private String type;
    private Course course;
    private Instant datePublication;
    private Instant createdAt;
    private Instant updatedAt;
}
