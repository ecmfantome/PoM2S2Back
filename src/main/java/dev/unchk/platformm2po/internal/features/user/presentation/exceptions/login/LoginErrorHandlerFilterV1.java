package dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login;

import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.error.IErrorHandling;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@AllArgsConstructor
public class LoginErrorHandlerFilterV1 implements LoginErrorHandlerFilter {

    private Map<String, IErrorHandling> errorHandlingMap;

    @Override
    public ExchangeFilterFunction handlerStatusErrorFilter() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            HttpStatusCode statusCode = clientResponse.statusCode();
            //&& statusCode != HttpStatus.UNAUTHORIZED
            if (statusCode.isError() ) {
                String statusCodeFormat = statusCode.toString().split(" ")[0];//Je le format pour seulement recuperer le code exp : 404 afin de recuper instance dans le map
                IErrorHandling errorHandling = errorHandlingMap.get(statusCodeFormat);
                if (errorHandling == null) {
                    throw new RuntimeException("Erreur Server ce status code n'est pris en charge ! : " + statusCodeFormat);
                } else {
                    return errorHandling.ErrorHandle(clientResponse);
                }
            }
            return Mono.just(clientResponse);
        });
    }
}
