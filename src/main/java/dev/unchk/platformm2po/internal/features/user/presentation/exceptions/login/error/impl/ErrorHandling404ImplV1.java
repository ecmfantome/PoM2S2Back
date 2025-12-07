package dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.impl;

import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.UserNotFoundException;
import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.IErrorHandling;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@Service("404")
public class ErrorHandling404ImplV1 implements IErrorHandling {

    @Override
    public Mono<ClientResponse> ErrorHandle(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(String.class).flatMap(errorResponse ->
                Mono.error(new UserNotFoundException(errorResponse))
        );
    }
}
