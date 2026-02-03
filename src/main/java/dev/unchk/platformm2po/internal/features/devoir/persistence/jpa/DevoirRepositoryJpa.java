package dev.unchk.platformm2po.internal.features.devoir.persistence.jpa;

import dev.unchk.platformm2po.internal.features.devoir.persistence.entities.DevoirJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevoirRepositoryJpa extends JpaRepository<DevoirJpa, String> {
}
