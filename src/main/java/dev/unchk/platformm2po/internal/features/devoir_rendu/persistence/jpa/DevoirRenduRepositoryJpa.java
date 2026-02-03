package dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.jpa;

import dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.entities.DevoirRenduJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevoirRenduRepositoryJpa extends JpaRepository<DevoirRenduJpa, String> {
}
