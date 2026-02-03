package dev.unchk.platformm2po.internal.features.courses.persistence.entities;


import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.entities.AdminJpa;
import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities.ModuleJpa;
import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.entities.StudentJpa;
import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class CourseJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String semester;

    private String description;

    @Column(nullable = false)
    private int credits;

    @ManyToMany(mappedBy = "courses")
    private Set<StudentJpa> students = new HashSet<>();
    @ManyToMany(mappedBy = "courses")
    private Set<TeacherJpa> teachers = new HashSet<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ModuleJpa moduleJpa;

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
