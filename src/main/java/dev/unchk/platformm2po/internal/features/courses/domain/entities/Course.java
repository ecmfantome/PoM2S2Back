package dev.unchk.platformm2po.internal.features.courses.domain.entities;


import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    private String id;
    private String titre;
    private String description;
    private int credit;
    private String semestre;
    private Admin createdBy;
    private Module_ module;
    private Instant createdAt;
    private Instant updatedAt;
}
