package dev.unchk.platformm2po.internal.features.devoir.application.use_case;

import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirResponse;
import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirSaveRequest;
import dev.unchk.platformm2po.internal.features.devoir.domain.entities.Devoir;
import dev.unchk.platformm2po.internal.features.devoir.domain.repository.DevoirRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.devoir.application.mapper.DevoirMapper.toEntityDevoirsResponse;
import static dev.unchk.platformm2po.internal.features.devoir.application.mapper.DevoirMapper.toEntityDevoirsSave;


@AllArgsConstructor
@Service
public class DevoirSaveUC {
    DevoirRepository repository;

    public List<DevoirResponse> execute(List<DevoirSaveRequest> requests) {
        //------Mapping
        List<Devoir> courses = toEntityDevoirsSave(requests);
        //------Save And Response
        return toEntityDevoirsResponse(repository.saveDevoirs(courses));
    }
}
