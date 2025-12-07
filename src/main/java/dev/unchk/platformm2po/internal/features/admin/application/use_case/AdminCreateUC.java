package dev.unchk.platformm2po.internal.features.admin.application.use_case;

import dev.unchk.platformm2po.internal.features.admin.application.dto.AdminRequest;
import dev.unchk.platformm2po.internal.features.admin.application.mapper.AdminMapper;
import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.admin.domain.repository.AdminRepository;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserSignUpUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AdminCreateUC {
    AdminRepository repository;
    IUserSignUpUC userSignUpUC;

    public String execute(AdminRequest adminRequest) {
        //------Mapping
        Admin admin = AdminMapper.toEntity(adminRequest);
        //------Save
        String id = repository.saveAdmin(admin);
        //-----Mapping
        UserRequestSignUp userRequestSignUp = AdminMapper.toUserSignUp(adminRequest, id);
        //-----Save user firebase
        userSignUpUC.execute(userRequestSignUp);
        return id;
    }
}
