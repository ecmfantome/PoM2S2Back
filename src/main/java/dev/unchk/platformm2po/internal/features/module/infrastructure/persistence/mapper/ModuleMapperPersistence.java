package dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.mapper;

import dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.entities.AdminJpa;
import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;
import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities.ModuleJpa;
import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.admin.infrastructure.persistence.mapper.AdminMapperPersistence.toEntityAdmin;
import static dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.mapper.TeacherMapperPersistence.toEntityTeacher;

public class ModuleMapperPersistence {
    //----------Mapper to entity jpa
    public static List<ModuleJpa> toModulesJpa(List<Module_> modules) {
        return modules.stream().map(ModuleMapperPersistence::toModuleJpa
        ).toList();
    }

    public static ModuleJpa toModuleJpa(Module_ module) {
        AdminJpa adminJpa = AdminJpa.builder().id(module.getCreatedBy().id()).build();
        ModuleJpa moduleJpa = ModuleJpa.builder()
                .name(module.getName())
                .code(module.getCode())
                .semester(module.getSemester())
                .createdBy(adminJpa)
                .build();
        if (module.getResponsible() != null && module.getResponsible().id() != null) {
            TeacherJpa teacherJpa = TeacherJpa.builder().id(module.getResponsible().id()).build();
            moduleJpa.setResponsible(teacherJpa);
        }
        return moduleJpa;
    }


    //----------Mapper to entity domain
    public static List<Module_> toModules(List<ModuleJpa> modules) {
        return modules.stream().map(ModuleMapperPersistence::toModule).toList();
    }

    //----------Mapper to entity domain
    public static Module_ toModule(ModuleJpa moduleJpa) {
        Module_ module = Module_.builder()
                .id(moduleJpa.getId())
                .name(moduleJpa.getName())
                .code(moduleJpa.getCode())
                .semester(moduleJpa.getSemester())
                .createdBy(toEntityAdmin(moduleJpa.getCreatedBy()))
                .createdAt(moduleJpa.getCreatedAt())
                .updatedAt(moduleJpa.getUpdatedAt())
                .build();
        if (moduleJpa.getResponsible() != null && moduleJpa.getResponsible().getId() != null) {
            module.setResponsible(toEntityTeacher(moduleJpa.getResponsible()));
        }
        return module;
    }
}
