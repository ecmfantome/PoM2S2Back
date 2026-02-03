package dev.unchk.platformm2po.internal.features.devoir.persistence.entities;


import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
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
@Table(name = "devoir")
@EntityListeners(AuditingEntityListener.class)
public class DevoirJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String consigne;

    @Column(nullable = false)
    private Instant dateLimite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private CourseJpa courseJpa;
    //Champs System
    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;
}
