package dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.repository;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.admin.domain.repository.AdminRepository;
import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.entities.AdminJpa;
import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.jpa.AdminRepositoryJpa;
import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.mapper.AdminMapperPersistence;
import dev.unchk.platformm2po.internal.features.admin.presentation.exceptions.AdminNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.mapper.AdminMapperPersistence.toEntityAdmin;


@AllArgsConstructor
@Service
public class AdminRepositoryImpV1 implements AdminRepository {

    private final AdminRepositoryJpa adminRepositoryJpa;

    @Override
    public String saveAdmin(Admin admin) {
        //-----Mapping
        AdminJpa adminJpa = AdminMapperPersistence.toJpa(admin);
        //-----Save
        AdminJpa saved = adminRepositoryJpa.save(adminJpa);
        //-----Response
        return saved.getId();
    }

    @Override
    public Admin findAdminById(String adminId) {
        Optional<AdminJpa> adminJpaFind = adminRepositoryJpa.findById(adminId);
        if (adminJpaFind.isEmpty()) throw new AdminNotFoundException();
        return toEntityAdmin(adminJpaFind.get());
    }

    @Override
    public void deleteAdmin(String adminId) {
        boolean isPresent = adminRepositoryJpa.findById(adminId).isPresent();
        if (!isPresent) throw new AdminNotFoundException();
        adminRepositoryJpa.deleteById(adminId);
    }

    @Override
    public void updateAdmin(String adminId, Admin admin) {
        Optional<AdminJpa> adminJpaFind = adminRepositoryJpa.findById(adminId);
        if (adminJpaFind.isEmpty()) throw new AdminNotFoundException();
        //-----Mapping
        AdminJpa adminJpa = AdminMapperPersistence.toJpa(admin);
        adminJpa.setId(adminId);
        adminRepositoryJpa.save(adminJpa);
    }
}
