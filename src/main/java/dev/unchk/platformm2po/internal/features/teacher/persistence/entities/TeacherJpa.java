package dev.unchk.platformm2po.internal.features.teacher.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "teachers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true)
    private String registration_number;
    private String speciality;
    private String department;
}
