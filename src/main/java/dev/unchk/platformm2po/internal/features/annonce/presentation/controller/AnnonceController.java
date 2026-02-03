package dev.unchk.platformm2po.internal.features.annonce.presentation.controller;

import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceResponse;
import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceSaveRequest;
import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceUpdateRequest;
import dev.unchk.platformm2po.internal.features.annonce.application.use_case.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/annonce")
@RestController
@AllArgsConstructor
public class AnnonceController {

    private AnnonceSaveUC annonceSaveUC;
    private AnnonceFindAllUC findAllUC;
    private AnnonceFindByIdUC findByIdUC;
    private AnnonceDeleteByIdUC deleteByIdUC;
    private AnnonceUpdateByIdUC updateByIdUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<AnnonceResponse> saveAnnonces(@Valid @RequestBody Flux<AnnonceSaveRequest> requestFlux) {
        return requestFlux
                .collectList()
                .flatMapMany(list -> Flux.fromIterable(annonceSaveUC.execute(list)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<AnnonceResponse> findAllAnnonces() {
        return Flux.fromIterable(findAllUC.execute());
    }

    @GetMapping("{annonceId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AnnonceResponse> findByAnnonceId(@PathVariable("annonceId") String annonceId) {
        return Mono.fromSupplier(() -> findByIdUC.execute(annonceId));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateAnnonce(@Valid @RequestBody Mono<AnnonceUpdateRequest> annonceUpdateRequestMono) {
        return annonceUpdateRequestMono
                .flatMap(annonceUpdateRequest -> Mono.fromRunnable(() -> updateByIdUC.execute(annonceUpdateRequest)));
    }

    @DeleteMapping("{annonceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>>  deleteAnnonce(@PathVariable String annonceId) {
        return Mono.fromRunnable(() -> deleteByIdUC.execute(annonceId));
    }
}
