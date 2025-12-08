package dev.unchk.platformm2po.internal.features.module.application.use_case;

import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleResponse;
import dev.unchk.platformm2po.internal.features.module.domain.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.module.application.mapper.ModuleMapper.toEntityModuleResponse;

@AllArgsConstructor
@Service
public class ModuleFindByIdUC {
    ModuleRepository repository;

    public ModuleResponse execute(String moduleId) {
        //------find
        return toEntityModuleResponse(repository.findModuleById(moduleId));
    }
}
