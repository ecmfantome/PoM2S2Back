package dev.unchk.platformm2po.internal.features.devoir.application.use_case;

import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirUpdateRequest;
import dev.unchk.platformm2po.internal.features.devoir.domain.repository.DevoirRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.devoir.application.mapper.DevoirMapper.toEntityDevoirUpdate;


@AllArgsConstructor
@Service
public class DevoirUpdateByIdUC {
    DevoirRepository repository;

    public void execute(DevoirUpdateRequest devoir) {
        //------find
        repository.updateDevoirById(toEntityDevoirUpdate(devoir));
    }
}
