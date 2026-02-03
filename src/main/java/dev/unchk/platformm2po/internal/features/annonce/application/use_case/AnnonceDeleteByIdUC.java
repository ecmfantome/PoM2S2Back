package dev.unchk.platformm2po.internal.features.annonce.application.use_case;

import dev.unchk.platformm2po.internal.features.annonce.domain.repository.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnnonceDeleteByIdUC {
    AnnonceRepository repository;

    public void execute(String annonceId) {
        //------delete
        repository.deleteAnnonceById(annonceId);
    }
}
