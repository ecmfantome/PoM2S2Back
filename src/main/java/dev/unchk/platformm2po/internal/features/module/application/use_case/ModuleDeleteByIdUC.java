package dev.unchk.platformm2po.internal.features.module.application.use_case;

import dev.unchk.platformm2po.internal.features.module.domain.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModuleDeleteByIdUC {
    ModuleRepository repository;

    public void execute(String moduleId) {
        //------delete
        repository.deleteModuleById(moduleId);
    }
}
