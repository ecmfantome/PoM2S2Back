package dev.unchk.platformm2po.internal.features.admin.application.use_case;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.admin.domain.repository.AdminRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.IAdminFindByIdUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AdminFindByIdUCImp implements IAdminFindByIdUC {
    AdminRepository repository;

    public Admin execute(String adminId) {
        return repository.findAdminById(adminId);
    }
}
