package dev.unchk.platformm2po.internal.features.admin.application.use_case;

import dev.unchk.platformm2po.internal.features.admin.application.dto.AdminUpdateRequest;
import dev.unchk.platformm2po.internal.features.admin.application.mapper.AdminMapper;
import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.admin.domain.repository.AdminRepository;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserUpdateClaimsUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.admin.application.mapper.AdminMapper.toUserRequestUpdateClaims;


@AllArgsConstructor
@Service
public class AdminUpdateUC {
    AdminRepository repository;
    IUserUpdateClaimsUC userUpdateClaimsUC;

    public void execute(AdminUpdateRequest adminUpdateRequest) {
        //------Mapping
        Admin admin = AdminMapper.toEntity(adminUpdateRequest);
        UserRequestUpdateClaims userRequestUpdateClaims = toUserRequestUpdateClaims(adminUpdateRequest);
        //-----update claims firebase
        String userId = userUpdateClaimsUC.execute(userRequestUpdateClaims);
        //-----update admin database
        repository.updateAdmin(userId, admin);
    }
}
