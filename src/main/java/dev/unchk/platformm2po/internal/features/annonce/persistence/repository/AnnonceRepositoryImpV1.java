package dev.unchk.platformm2po.internal.features.annonce.persistence.repository;

import dev.unchk.platformm2po.internal.features.annonce.persistence.entities.AnnonceJpa;
import dev.unchk.platformm2po.internal.features.annonce.persistence.jpa.AnnonceRepositoryJpa;
import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.annonce.domain.entities.Annonce;
import dev.unchk.platformm2po.internal.features.annonce.domain.exceptions.AnnonceNotFoundException;
import dev.unchk.platformm2po.internal.features.annonce.domain.repository.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.annonce.persistence.mapper.AnnonceMapperPersistence.*;


@Service
@AllArgsConstructor
public class AnnonceRepositoryImpV1 implements AnnonceRepository {
    private final AnnonceRepositoryJpa annonceRepositoryJpa;

    @Override
    public List<Annonce> saveAnnonces(List<Annonce> annonces) {
        List<AnnonceJpa> annonceJpaSave = annonceRepositoryJpa.saveAll(toAnnoncesJpa(annonces));
        return toAnnonces(annonceJpaSave);
    }

    @Override
    public List<Annonce> findAllAnnonces() {
        return toAnnonces(annonceRepositoryJpa.findAll());
    }

    @Override
    public Annonce findAnnonceById(String annonceId) {
        AnnonceJpa existingAnnonce = annonceRepositoryJpa.findById(annonceId)
                .orElseThrow(AnnonceNotFoundException::new);
        return toAnnonce(existingAnnonce);
    }

    @Override
    public void updateAnnonceById(Annonce annonce) {
        AnnonceJpa existingAnnonce = annonceRepositoryJpa.findById(annonce.getId())
                .orElseThrow(AnnonceNotFoundException::new);
        //
        existingAnnonce.setTitre(annonce.getTitre());
        existingAnnonce.setType(annonce.getType());
        existingAnnonce.setMessage(annonce.getMessage());
        existingAnnonce.setDatePublication(annonce.getDatePublication());
        if (annonce.getCourse() != null && annonce.getCourse().getId() != null) {
            existingAnnonce.setCourseJpa(CourseJpa.builder().id(annonce.getCourse().getId()).build());
        }
        //
        annonceRepositoryJpa.save(existingAnnonce);
    }

    @Override
    public void deleteAnnonceById(String annonceId) {
        AnnonceJpa existingAnnonce = annonceRepositoryJpa.findById(annonceId)
                .orElseThrow(AnnonceNotFoundException::new);
        annonceRepositoryJpa.delete(existingAnnonce);
    }


}
