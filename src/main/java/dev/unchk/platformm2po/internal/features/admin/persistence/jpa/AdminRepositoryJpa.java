package dev.unchk.platformm2po.internal.features.admin.persistence.jpa;

import dev.unchk.platformm2po.internal.features.admin.persistence.entities.AdminJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositoryJpa extends JpaRepository <AdminJpa, String>{
}
