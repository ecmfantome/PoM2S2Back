package dev.unchk.platformm2po.internal.features.devoir.application.use_case;

import dev.unchk.platformm2po.internal.features.devoir.domain.repository.DevoirRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DevoirDeleteByIdUC {
    DevoirRepository repository;

    public void execute(String devoirId) {
        //------delete
        repository.deleteDevoirById(devoirId);
    }
}
