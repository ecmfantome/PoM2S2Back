package dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.mapper;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.entities.AdminJpa;


public class AdminMapperPersistence {
    //----------Mapper to entity jpa
    public static AdminJpa toJpa(Admin admin) {
        return AdminJpa.builder()
                .post(admin.post())
                .build();
    }

    //----------Mapper to entity jpa
    public static Admin toEntityAdmin(AdminJpa adminJpa) {
        return Admin.builder()
                .id(adminJpa.getId())
                .post(adminJpa.getPost())
                .build();
    }
}
