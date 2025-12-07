package dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@Table(name = "students")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true)
    private String matricule;
    private String anneeEntre;
}
