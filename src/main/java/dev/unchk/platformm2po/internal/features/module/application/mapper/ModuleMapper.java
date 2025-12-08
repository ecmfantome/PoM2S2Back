package dev.unchk.platformm2po.internal.features.module.application.mapper;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleResponse;
import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleSaveRequest;
import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleUpdateRequest;
import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;

import java.util.List;

public class ModuleMapper {

    //----------Mapper to entity
    public static List<Module_> toEntityModulesSave(List<ModuleSaveRequest> requests) {
        return requests.stream().map(ModuleMapper::toEntityModuleSave).toList();
    }

    public static List<ModuleResponse> toEntityModulesResponse(List<Module_> requests) {
        return requests.stream().map(ModuleMapper::toEntityModuleResponse).toList();
    }

    public static List<Module_> toEntityModulesUpdate(List<ModuleUpdateRequest> requests) {
        return requests.stream().map(ModuleMapper::toEntityModuleUpdate).toList();
    }

    //
    public static Module_ toEntityModuleSave(ModuleSaveRequest request) {
        Admin admin = Admin.builder().id(request.adminId()).build();
        Teacher teacher = Teacher.builder().id(request.responsibleId()).build();
        return Module_.builder()
                .name(request.name())
                .code(request.code())
                .semester(request.semester())
                .responsible(teacher)
                .createdBy(admin)
                .build();
    }

    public static ModuleResponse toEntityModuleResponse(Module_ request) {

        return ModuleResponse.builder()
                .id(request.getId())
                .name(request.getName())
                .code(request.getCode())
                .semester(request.getSemester())
                .responsible(request.getResponsible())
                .createdBy(request.getCreatedBy())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .build();
    }


    //
    public static Module_ toEntityModuleUpdate(ModuleUpdateRequest request) {
        Admin admin = Admin.builder().id(request.createdBy()).build();

        Module_ module = Module_.builder()
                .id(request.id())
                .name(request.name())
                .code(request.code())
                .semester(request.semester())
                .createdBy(admin)
                .build();
        if (request.responsibleId() != null) {
            Teacher teacher = Teacher.builder().id(request.responsibleId()).build();
            module.setResponsible(teacher);
        }
        return module;
    }

}
