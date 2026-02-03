package dev.unchk.platformm2po.internal.features.message.persistence.jpa;

import dev.unchk.platformm2po.internal.features.message.persistence.entities.MessageJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepositoryJpa extends JpaRepository<MessageJpa, String> {
}
