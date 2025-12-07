package dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error;

import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public interface IErrorHandling {
    Mono<ClientResponse> ErrorHandle(ClientResponse clientResponse);
}
