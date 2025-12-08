package dev.unchk.platformm2po.internal.features.module.application.use_case;

import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleResponse;
import dev.unchk.platformm2po.internal.features.module.domain.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.module.application.mapper.ModuleMapper.toEntityModulesResponse;


@AllArgsConstructor
@Service
public class ModuleFindAllUC {
    ModuleRepository repository;

    public List<ModuleResponse> execute() {
        //------Save
        return toEntityModulesResponse(repository.findAllModules());
    }
}
