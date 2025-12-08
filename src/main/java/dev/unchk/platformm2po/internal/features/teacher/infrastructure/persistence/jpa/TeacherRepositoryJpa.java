package dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.jpa;

import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositoryJpa extends JpaRepository <TeacherJpa, String>{
}
