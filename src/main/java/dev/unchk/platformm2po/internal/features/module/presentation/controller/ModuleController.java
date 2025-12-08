package dev.unchk.platformm2po.internal.features.module.presentation.controller;

import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleResponse;
import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleSaveRequest;
import dev.unchk.platformm2po.internal.features.module.application.dto.ModuleUpdateRequest;
import dev.unchk.platformm2po.internal.features.module.application.use_case.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/module")
@RestController
@AllArgsConstructor
public class ModuleController {

    private ModuleSaveUC moduleSaveUC;
    private ModuleFindAllUC findAllUC;
    private ModuleFindByIdUC findByIdUC;
    private ModuleDeleteByIdUC deleteByIdUC;
    private ModuleUpdateByIdUC updateByIdUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<ModuleResponse> saveModules(@Valid @RequestBody Flux<ModuleSaveRequest> requestFlux) {
        return requestFlux
                .collectList()
                .flatMapMany(list -> Flux.fromIterable(moduleSaveUC.execute(list)));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ModuleResponse> findAllModules() {
        return Flux.fromIterable(findAllUC.execute());
    }

    @GetMapping("{moduleId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ModuleResponse> findByModuleId(@PathVariable("moduleId") String moduleId) {
        return Mono.fromSupplier(() -> findByIdUC.execute(moduleId));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateModule(@Valid @RequestBody Mono<ModuleUpdateRequest> moduleUpdateRequestMono) {
        return moduleUpdateRequestMono
                .flatMap(moduleUpdateRequest -> Mono.fromRunnable(() -> updateByIdUC.execute(moduleUpdateRequest)));
    }

    @DeleteMapping("{moduleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>>  deleteModule(@PathVariable String moduleId) {
        return Mono.fromRunnable(() -> deleteByIdUC.execute(moduleId));
    }
}
