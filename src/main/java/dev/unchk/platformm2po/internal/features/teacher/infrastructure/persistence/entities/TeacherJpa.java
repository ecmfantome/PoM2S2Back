package dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities;


import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities.ModuleJpa;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teachers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class TeacherJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true)
    private String registration_number;
    private String speciality;
    private String department;

    //Relations
    @OneToMany(mappedBy = "responsible")
    private List<ModuleJpa> modules = new ArrayList<>();

    //Champs System
    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;
}
