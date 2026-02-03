package dev.unchk.platformm2po.internal.features.devoir.application.use_case;

import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirResponse;
import dev.unchk.platformm2po.internal.features.devoir.domain.repository.DevoirRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.devoir.application.mapper.DevoirMapper.toEntityDevoirsResponse;


@AllArgsConstructor
@Service
public class DevoirFindAllUC {
    DevoirRepository repository;

    public List<DevoirResponse> execute() {
        //------Save
        return toEntityDevoirsResponse(repository.findAllDevoirs());
    }
}
