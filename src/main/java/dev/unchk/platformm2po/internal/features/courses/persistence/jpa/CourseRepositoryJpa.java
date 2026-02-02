package dev.unchk.platformm2po.internal.features.courses.persistence.jpa;

import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepositoryJpa extends JpaRepository<CourseJpa, String> {
}
