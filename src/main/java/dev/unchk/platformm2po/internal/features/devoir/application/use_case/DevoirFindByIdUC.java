package dev.unchk.platformm2po.internal.features.devoir.application.use_case;

import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirResponse;
import dev.unchk.platformm2po.internal.features.devoir.domain.repository.DevoirRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.devoir.application.mapper.DevoirMapper.toEntityDevoirResponse;


@AllArgsConstructor
@Service
public class DevoirFindByIdUC {
    DevoirRepository repository;

    public DevoirResponse execute(String devoirId) {
        //------find
        return toEntityDevoirResponse(repository.findDevoirById(devoirId));
    }
}
