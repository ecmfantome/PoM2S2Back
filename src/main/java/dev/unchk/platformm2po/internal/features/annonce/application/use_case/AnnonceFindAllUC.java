package dev.unchk.platformm2po.internal.features.annonce.application.use_case;

import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceResponse;
import dev.unchk.platformm2po.internal.features.annonce.domain.repository.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.annonce.application.mapper.AnnonceMapper.toEntityAnnoncesResponse;


@AllArgsConstructor
@Service
public class AnnonceFindAllUC {
    AnnonceRepository repository;

    public List<AnnonceResponse> execute() {
        //------Save
        return toEntityAnnoncesResponse(repository.findAllAnnonces());
    }
}
