package dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.jpa;

import dev.unchk.platformm2po.internal.features.student.insfrastructure.persistence.entities.StudentJpa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepositoryJpa extends JpaRepository <StudentJpa, String>{

    @Modifying
    @Transactional
    @Query("UPDATE StudentJpa s SET s.anneeEntre = :annee WHERE s.id = :id")
    int updateBackToSchoolYear(@Param("id") String id, @Param("annee") String backToSchoolYear);
}
