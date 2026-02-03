package dev.unchk.platformm2po.internal.features.annonce.application.use_case;

import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceUpdateRequest;
import dev.unchk.platformm2po.internal.features.annonce.domain.repository.AnnonceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.annonce.application.mapper.AnnonceMapper.toEntityAnnonceUpdate;

@AllArgsConstructor
@Service
public class AnnonceUpdateByIdUC {
    AnnonceRepository repository;

    public void execute(AnnonceUpdateRequest devoir) {
        //------find
        repository.updateAnnonceById(toEntityAnnonceUpdate(devoir));
    }
}
