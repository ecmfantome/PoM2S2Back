package dev.unchk.platformm2po.internal.features.devoir.presentation.controller;

import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirResponse;
import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirSaveRequest;
import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirUpdateRequest;
import dev.unchk.platformm2po.internal.features.devoir.application.use_case.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/devoir")
@RestController
@AllArgsConstructor
public class DevoirController {

    private DevoirSaveUC devoirSaveUC;
    private DevoirFindAllUC findAllUC;
    private DevoirFindByIdUC findByIdUC;
    private DevoirDeleteByIdUC deleteByIdUC;
    private DevoirUpdateByIdUC updateByIdUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<DevoirResponse> saveDevoirs(@Valid @RequestBody Flux<DevoirSaveRequest> requestFlux) {
        return requestFlux
                .collectList()
                .flatMapMany(list -> Flux.fromIterable(devoirSaveUC.execute(list)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<DevoirResponse> findAllDevoirs() {
        return Flux.fromIterable(findAllUC.execute());
    }

    @GetMapping("{devoirId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DevoirResponse> findByDevoirId(@PathVariable("devoirId") String devoirId) {
        return Mono.fromSupplier(() -> findByIdUC.execute(devoirId));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateDevoir(@Valid @RequestBody Mono<DevoirUpdateRequest> devoirUpdateRequestMono) {
        return devoirUpdateRequestMono
                .flatMap(devoirUpdateRequest -> Mono.fromRunnable(() -> updateByIdUC.execute(devoirUpdateRequest)));
    }

    @DeleteMapping("{devoirId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>>  deleteDevoir(@PathVariable String devoirId) {
        return Mono.fromRunnable(() -> deleteByIdUC.execute(devoirId));
    }
}
