package dev.unchk.platformm2po.internal.shared.application.use_case;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;

public interface IAdminFindByIdUC {
     Admin execute(String adminId);
}
