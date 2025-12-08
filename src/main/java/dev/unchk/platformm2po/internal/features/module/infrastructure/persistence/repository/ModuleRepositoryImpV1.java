package dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.repository;

import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;
import dev.unchk.platformm2po.internal.features.module.domain.repository.ModuleRepository;
import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities.ModuleJpa;
import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.jpa.ModuleRepositoryJpa;
import dev.unchk.platformm2po.internal.features.module.presentation.exceptions.ModuleNotFoundException;
import dev.unchk.platformm2po.internal.features.teacher.infrastructure.persistence.entities.TeacherJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.mapper.ModuleMapperPersistence.*;

@Service
@AllArgsConstructor
public class ModuleRepositoryImpV1 implements ModuleRepository {
    private final ModuleRepositoryJpa moduleRepositoryJpa;

    @Override
    public List<Module_> saveModules(List<Module_> modules) {
        List<ModuleJpa> moduleJpaSave = moduleRepositoryJpa.saveAll(toModulesJpa(modules));
        return toModules(moduleJpaSave);
    }

    @Override
    public List<Module_> findAllModules() {
        return toModules(moduleRepositoryJpa.findAll());
    }

    @Override
    public Module_ findModuleById(String moduleId) {
        ModuleJpa existingModule = moduleRepositoryJpa.findById(moduleId)
                .orElseThrow(ModuleNotFoundException::new);
        return toModule(existingModule);
    }

    @Override
    public void updateModuleById(Module_ module) {
        ModuleJpa existingModule = moduleRepositoryJpa.findById(module.getId())
                .orElseThrow(ModuleNotFoundException::new);
        //
        existingModule.setName(module.getName());
        existingModule.setSemester(module.getSemester());
        existingModule.setCode(module.getCode());
        if (module.getResponsible() != null && module.getResponsible().id() != null) {
            existingModule.setResponsible(TeacherJpa.builder().id(module.getResponsible().id()).build());
        }
        //
        moduleRepositoryJpa.save(existingModule);
    }

    @Override
    public void deleteModuleById(String moduleId) {
        ModuleJpa existingModule = moduleRepositoryJpa.findById(moduleId)
                .orElseThrow(ModuleNotFoundException::new);
        moduleRepositoryJpa.delete(existingModule);
    }


}
