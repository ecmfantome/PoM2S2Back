package dev.unchk.platformm2po.internal.features.devoir.persistence.repository;

import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.devoir.domain.entities.Devoir;
import dev.unchk.platformm2po.internal.features.devoir.domain.exceptions.DevoirNotFoundException;
import dev.unchk.platformm2po.internal.features.devoir.domain.repository.DevoirRepository;
import dev.unchk.platformm2po.internal.features.devoir.persistence.entities.DevoirJpa;
import dev.unchk.platformm2po.internal.features.devoir.persistence.jpa.DevoirRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.devoir.persistence.mapper.DevoirMapperPersistence.*;


@Service
@AllArgsConstructor
public class DevoirRepositoryImpV1 implements DevoirRepository {
    private final DevoirRepositoryJpa devoirRepositoryJpa;

    @Override
    public List<Devoir> saveDevoirs(List<Devoir> devoirs) {
        List<DevoirJpa> devoirJpaSave = devoirRepositoryJpa.saveAll(toDevoirsJpa(devoirs));
        return toDevoirs(devoirJpaSave);
    }

    @Override
    public List<Devoir> findAllDevoirs() {
        return toDevoirs(devoirRepositoryJpa.findAll());
    }

    @Override
    public Devoir findDevoirById(String devoirId) {
        DevoirJpa existingDevoir = devoirRepositoryJpa.findById(devoirId)
                .orElseThrow(DevoirNotFoundException::new);
        return toDevoir(existingDevoir);
    }

    @Override
    public void updateDevoirById(Devoir devoir) {
        DevoirJpa existingDevoir = devoirRepositoryJpa.findById(devoir.getId())
                .orElseThrow(DevoirNotFoundException::new);
        //
        existingDevoir.setTitre(devoir.getTitre());
        existingDevoir.setConsigne(devoir.getConsigne());
        existingDevoir.setDateLimite(devoir.getDateLimite());
        if (devoir.getCourse() != null && devoir.getCourse().getId() != null) {
            existingDevoir.setCourseJpa(CourseJpa.builder().id(devoir.getCourse().getId()).build());
        }
        //
        devoirRepositoryJpa.save(existingDevoir);
    }

    @Override
    public void deleteDevoirById(String devoirId) {
        DevoirJpa existingDevoir = devoirRepositoryJpa.findById(devoirId)
                .orElseThrow(DevoirNotFoundException::new);
        devoirRepositoryJpa.delete(existingDevoir);
    }


}
