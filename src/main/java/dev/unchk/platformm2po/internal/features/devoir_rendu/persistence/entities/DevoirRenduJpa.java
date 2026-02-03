package dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.entities;

import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.devoir.persistence.entities.DevoirJpa;
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
@Table(name = "devoir_rendu")
@EntityListeners(AuditingEntityListener.class)
public class DevoirRenduJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String description;

    @Lob
    @Column(nullable = false)
    private byte[] fileContent;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String contentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private DevoirJpa devoirJpa;

    //Champs System
    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;
}
