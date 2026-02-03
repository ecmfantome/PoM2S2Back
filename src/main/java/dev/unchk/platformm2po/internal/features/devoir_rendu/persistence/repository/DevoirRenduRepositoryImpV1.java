package dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.repository;

import dev.unchk.platformm2po.internal.features.devoir.domain.exceptions.DevoirNotFoundException;
import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.entities.DevoirRendu;
import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.repository.DevoirRenduRepository;
import dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.entities.DevoirRenduJpa;
import dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.jpa.DevoirRenduRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static dev.unchk.platformm2po.internal.features.devoir_rendu.persistence.mapper.DevoirRenduMapperPersistence.*;


@Service
@AllArgsConstructor
public class DevoirRenduRepositoryImpV1 implements DevoirRenduRepository {
    private final DevoirRenduRepositoryJpa devoirRenduRepositoryJpa;

    @Override
    public DevoirRendu saveDevoir(DevoirRendu devoirs) {
        DevoirRenduJpa devoirJpaSave = devoirRenduRepositoryJpa.save(toDevoirRenduJpa(devoirs));
        return toDevoirRendu(devoirJpaSave);
    }


    @Override
    public void deleteDevoirById(String devoirId) {
        DevoirRenduJpa existingDevoir = devoirRenduRepositoryJpa.findById(devoirId)
                .orElseThrow(DevoirNotFoundException::new);
        devoirRenduRepositoryJpa.delete(existingDevoir);
    }


}
