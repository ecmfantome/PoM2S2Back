package dev.unchk.platformm2po.internal.features.admin.application.use_case;

import dev.unchk.platformm2po.internal.features.admin.domain.repository.AdminRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserDeleteUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AdminDeleteUC {
    AdminRepository repository;
    IUserDeleteUC userDeleteUC;

    public void execute(String adminId) {
        //-----delete user firebase
        String userId = userDeleteUC.execute(adminId);
        //-----delete user database
        repository.deleteAdmin(userId);
    }
}
