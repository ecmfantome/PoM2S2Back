package dev.unchk.platformm2po.internal.features.admin.persistence.mapper;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.admin.persistence.entities.AdminJpa;


public class AdminMapperPersistence {
    //----------Mapper to entity jpa
    public static AdminJpa toJpa(Admin admin) {
        return AdminJpa.builder()
                .post(admin.post())
                .build();
    }
}
