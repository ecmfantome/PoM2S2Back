package dev.unchk.platformm2po.internal.features.devoir_rendu.domain.repository;

import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.entities.DevoirRendu;

import java.util.List;

public interface DevoirRenduRepository {
    DevoirRendu saveDevoir(DevoirRendu devoirs);
    void deleteDevoirById(String devoirId);
}
