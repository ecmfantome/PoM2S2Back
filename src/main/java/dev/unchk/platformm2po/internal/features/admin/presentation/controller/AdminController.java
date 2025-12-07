package dev.unchk.platformm2po.internal.features.admin.presentation.controller;

import dev.unchk.platformm2po.internal.features.admin.application.dto.AdminRequest;
import dev.unchk.platformm2po.internal.features.admin.application.dto.AdminUpdateRequest;
import dev.unchk.platformm2po.internal.features.admin.application.use_case.AdminCreateUC;
import dev.unchk.platformm2po.internal.features.admin.application.use_case.AdminDeleteUC;
import dev.unchk.platformm2po.internal.features.admin.application.use_case.AdminUpdateUC;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/admin")
@RestController
@AllArgsConstructor
public class AdminController {
    private AdminCreateUC adminCreateUC;
    private AdminDeleteUC adminDeleteUC;
    private AdminUpdateUC adminUpdateUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<String> createAdmin(@Valid @RequestBody Mono<AdminRequest> adminRequestMono) {
        return adminRequestMono
                .flatMap(adminRequest ->
                        Mono.fromCallable(() -> adminCreateUC.execute(adminRequest))
                );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateAdmin(@Valid @RequestBody Mono<AdminUpdateRequest> adminUpdateRequestMono) {
        return adminUpdateRequestMono
                .flatMap(adminUpdateRequest ->
                        Mono.fromRunnable(() -> adminUpdateUC.execute(adminUpdateRequest))
                );
    }


    @DeleteMapping("{adminId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<String> deleteAdmin(@PathVariable String adminId) {
        return Mono.fromRunnable(() -> adminDeleteUC.execute(adminId));
    }
}
