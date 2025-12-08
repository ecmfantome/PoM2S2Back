package dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities;


import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.entities.AdminJpa;
import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "module")
@EntityListeners(AuditingEntityListener.class)
public class ModuleJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String semester;

    @Column(nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private TeacherJpa responsible;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by", nullable = false)
    private AdminJpa createdBy;

    //Champs System

    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;


}
