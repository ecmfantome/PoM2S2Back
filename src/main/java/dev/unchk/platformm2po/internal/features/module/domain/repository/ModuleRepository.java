package dev.unchk.platformm2po.internal.features.module.domain.repository;

import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;

import java.util.List;

public interface ModuleRepository {
    List<Module_> saveModules(List<Module_> modules);

    List<Module_> findAllModules();

    Module_ findModuleById(String moduleId);

    void updateModuleById(Module_ module);

    void deleteModuleById(String moduleId);
}
