package dev.unchk.platformm2po.internal.features.annonce.application.use_case;

import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceResponse;
import dev.unchk.platformm2po.internal.features.annonce.domain.repository.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.annonce.application.mapper.AnnonceMapper.toEntityAnnonceResponse;

@AllArgsConstructor
@Service
public class AnnonceFindByIdUC {
    AnnonceRepository repository;

    public AnnonceResponse execute(String devoirId) {
        //------find
        return toEntityAnnonceResponse(repository.findAnnonceById(devoirId));
    }
}
