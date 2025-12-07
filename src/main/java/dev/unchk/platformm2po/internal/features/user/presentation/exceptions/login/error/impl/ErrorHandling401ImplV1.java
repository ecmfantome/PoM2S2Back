package dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.impl;

import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.UserBadRequestException;
import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.ExtractErrorMessage;
import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.IErrorHandling;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@Service("401")
@AllArgsConstructor
public class ErrorHandling401ImplV1 implements IErrorHandling {

    @Override
    public Mono<ClientResponse> ErrorHandle(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(String.class).flatMap(errorResponse ->
                Mono.error(new UserBadRequestException(ExtractErrorMessage.ErrorHandle(errorResponse)))
        );
    }
}
