package dev.unchk.platformm2po.internal.features.module.application.use_case;

import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleUpdateRequest;
import dev.unchk.platformm2po.internal.features.module.application.mapper.ModuleMapper;
import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;
import dev.unchk.platformm2po.internal.features.module.domain.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.module.application.mapper.ModuleMapper.toEntityModuleUpdate;
import static dev.unchk.platformm2po.internal.features.module.application.mapper.ModuleMapper.toEntityModulesUpdate;

@AllArgsConstructor
@Service
public class ModuleUpdateByIdUC {
    ModuleRepository repository;

    public void execute(ModuleUpdateRequest module) {
        //------find
        repository.updateModuleById(toEntityModuleUpdate(module));
    }
}
