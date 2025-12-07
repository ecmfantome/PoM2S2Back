package dev.unchk.platformm2po.internal.shared.application.use_case;

import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;

public interface IUserUpdateClaimsUC {
    String execute(UserRequestUpdateClaims userRequestUpdateClaims);
}
