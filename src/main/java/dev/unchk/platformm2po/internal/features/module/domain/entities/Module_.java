package dev.unchk.platformm2po.internal.features.module.domain.entities;


import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module_ {
    private String id;
    private String name;
    private String semester;
    private String code;
    private Teacher responsible;
    private Admin createdBy;
    private Instant createdAt;
    private Instant updatedAt;
}
