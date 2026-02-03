package dev.unchk.platformm2po.internal.features.devoir.domain.repository;

import dev.unchk.platformm2po.internal.features.devoir.domain.entities.Devoir;

import java.util.List;

public interface DevoirRepository {
    List<Devoir> saveDevoirs(List<Devoir> devoirs);

    List<Devoir> findAllDevoirs();

    Devoir findDevoirById(String devoirId);

    void updateDevoirById(Devoir devoir);

    void deleteDevoirById(String devoirId);
}
