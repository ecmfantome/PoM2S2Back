package dev.unchk.platformm2po.internal.features.devoir_rendu.presentation.controller;

import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirResponse;
import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirSaveRequest;
import dev.unchk.platformm2po.internal.features.devoir.application.use_case.*;
import dev.unchk.platformm2po.internal.features.devoir_rendu.application.use_case.DevoirRenduDeleteByIdUC;
import dev.unchk.platformm2po.internal.features.devoir_rendu.application.use_case.DevoirRenduSaveUC;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RequestMapping("api/v1/devoir_rendu")
@RestController
@AllArgsConstructor
public class DevoirRenduController {

    private DevoirRenduSaveUC devoirSaveUC;
    private DevoirRenduDeleteByIdUC deleteByIdUC;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> upload(
            @RequestParam String description,
            @RequestParam MultipartFile file
    ) throws IOException {
        devoirSaveUC.execute(
                description,
                file.getBytes(),
                file.getOriginalFilename(),
                file.getContentType()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{devoirId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteDevoir(@PathVariable String devoirId) {
        return Mono.fromRunnable(() -> deleteByIdUC.execute(devoirId));
    }
}
