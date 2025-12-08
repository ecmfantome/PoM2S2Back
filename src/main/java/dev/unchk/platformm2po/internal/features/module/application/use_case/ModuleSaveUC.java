package dev.unchk.platformm2po.internal.features.module.application.use_case;

import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleResponse;
import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleSaveRequest;
import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;
import dev.unchk.platformm2po.internal.features.module.domain.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.module.application.mapper.ModuleMapper.toEntityModulesResponse;
import static dev.unchk.platformm2po.internal.features.module.application.mapper.ModuleMapper.toEntityModulesSave;


@AllArgsConstructor
@Service
public class ModuleSaveUC {
    ModuleRepository repository;

    public List<ModuleResponse> execute(List<ModuleSaveRequest> requests) {
        //------Mapping
        List<Module_> modules = toEntityModulesSave(requests);
        //------Save And Response
        return toEntityModulesResponse(repository.saveModules(modules));
    }
}
