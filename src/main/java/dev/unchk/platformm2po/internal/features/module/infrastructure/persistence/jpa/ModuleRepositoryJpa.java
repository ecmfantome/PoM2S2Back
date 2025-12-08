package dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.jpa;

import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities.ModuleJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepositoryJpa extends JpaRepository<ModuleJpa, String> {
}
