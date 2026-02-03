package dev.unchk.platformm2po.internal.features.message.presentation.controller;

import dev.unchk.platformm2po.internal.features.message.application.dto.MessageResponse;
import dev.unchk.platformm2po.internal.features.message.application.dto.MessageSaveRequest;
import dev.unchk.platformm2po.internal.features.message.application.dto.MessageUpdateRequest;
import dev.unchk.platformm2po.internal.features.message.application.use_case.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/message")
@RestController
@AllArgsConstructor
public class MessageController {

    private MessageSaveUC messageSaveUC;
    private MessageDeleteByIdUC deleteByIdUC;
    private MessageUpdateByIdUC updateByIdUC;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<MessageResponse> saveMessages(@Valid @RequestBody Flux<MessageSaveRequest> requestFlux) {
        return requestFlux
                .collectList()
                .flatMapMany(list -> Flux.fromIterable(messageSaveUC.execute(list)));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Void>> updateMessage(@Valid @RequestBody Mono<MessageUpdateRequest> messageUpdateRequestMono) {
        return messageUpdateRequestMono
                .flatMap(messageUpdateRequest -> Mono.fromRunnable(() -> updateByIdUC.execute(messageUpdateRequest)));
    }

    @DeleteMapping("{messageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>>  deleteMessage(@PathVariable String messageId) {
        return Mono.fromRunnable(() -> deleteByIdUC.execute(messageId));
    }
}
