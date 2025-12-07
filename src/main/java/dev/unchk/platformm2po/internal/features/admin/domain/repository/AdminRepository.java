package dev.unchk.platformm2po.internal.features.admin.domain.repository;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;

public interface AdminRepository {
    String saveAdmin(Admin admin);

    void deleteAdmin(String adminId);

    void updateAdmin(String adminId, Admin admin);
}
