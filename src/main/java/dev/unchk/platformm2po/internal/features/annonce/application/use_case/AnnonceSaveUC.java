package dev.unchk.platformm2po.internal.features.annonce.application.use_case;

import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceResponse;
import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceSaveRequest;
import dev.unchk.platformm2po.internal.features.annonce.domain.entities.Annonce;
import dev.unchk.platformm2po.internal.features.annonce.domain.repository.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.annonce.application.mapper.AnnonceMapper.toEntityAnnoncesResponse;
import static dev.unchk.platformm2po.internal.features.annonce.application.mapper.AnnonceMapper.toEntityAnnoncesSave;

@AllArgsConstructor
@Service
public class AnnonceSaveUC {
   AnnonceRepository repository;

    public List<AnnonceResponse> execute(List<AnnonceSaveRequest> requests) {
        //------Mapping
        List<Annonce> courses = toEntityAnnoncesSave(requests);
        //------Save And Response
        return toEntityAnnoncesResponse(repository.saveAnnonces(courses));
    }
}
