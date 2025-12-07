package dev.unchk.platformm2po.internal.features.admin.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "admins")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String post;
}
