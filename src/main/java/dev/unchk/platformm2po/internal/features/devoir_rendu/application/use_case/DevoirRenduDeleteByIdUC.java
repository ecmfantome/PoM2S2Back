package dev.unchk.platformm2po.internal.features.devoir_rendu.application.use_case;

import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.repository.DevoirRenduRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DevoirRenduDeleteByIdUC {
    DevoirRenduRepository repository;

    public void execute(String devoirId) {
        //------delete
        repository.deleteDevoirById(devoirId);
    }
}
