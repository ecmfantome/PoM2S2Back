package dev.unchk.platformm2po.internal.features.annonce.domain.repository;

import dev.unchk.platformm2po.internal.features.annonce.domain.entities.Annonce;

import java.util.List;

public interface AnnonceRepository {
    List<Annonce> saveAnnonces(List<Annonce> devoirs);

    List<Annonce> findAllAnnonces();

    Annonce findAnnonceById(String devoirId);

    void updateAnnonceById(Annonce devoir);

    void deleteAnnonceById(String devoirId);
}
