package dev.unchk.platformm2po.internal.features.annonce.persistence.jpa;

import dev.unchk.platformm2po.internal.features.annonce.persistence.entities.AnnonceJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepositoryJpa extends JpaRepository<AnnonceJpa, String> {
}
