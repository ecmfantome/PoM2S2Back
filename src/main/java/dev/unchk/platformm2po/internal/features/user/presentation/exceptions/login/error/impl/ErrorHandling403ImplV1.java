package dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.impl;

import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.UserForbiddenException;
import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.IErrorHandling;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@Service("403")
public class ErrorHandling403ImplV1 implements IErrorHandling {
    @Override
    public Mono<ClientResponse> ErrorHandle(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(String.class).flatMap(errorResponse ->
                Mono.error(new UserForbiddenException(errorResponse))
        );
    }
}
