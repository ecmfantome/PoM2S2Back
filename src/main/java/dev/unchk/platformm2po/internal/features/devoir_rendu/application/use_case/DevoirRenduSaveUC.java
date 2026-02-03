package dev.unchk.platformm2po.internal.features.devoir_rendu.application.use_case;

import dev.unchk.platformm2po.internal.features.devoir_rendu.application.dto.DevoirRenduResponse;
import dev.unchk.platformm2po.internal.features.devoir_rendu.application.dto.DevoirRenduSaveRequest;
import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.entities.DevoirRendu;
import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.repository.DevoirRenduRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

import static dev.unchk.platformm2po.internal.features.devoir_rendu.application.mapper.DevoirRenduMapper.toEntityDevoirRenduResponse;
import static dev.unchk.platformm2po.internal.features.devoir_rendu.application.mapper.DevoirRenduMapper.toEntityDevoirRenduSave;


@AllArgsConstructor
@Service
public class DevoirRenduSaveUC {
    DevoirRenduRepository repository;

    public DevoirRenduResponse execute(String description,
                                       byte[] fileContent,
                                       String fileName,
                                       String contentType) {
        //------Mapping
        DevoirRendu devoir = new DevoirRendu(
                UUID.randomUUID().toString(),
                description,
                contentType,
                fileName,
                fileContent,
                Instant.now()
        );
        //------Save And Response
        return toEntityDevoirRenduResponse(repository.saveDevoir(devoir));
    }
}
