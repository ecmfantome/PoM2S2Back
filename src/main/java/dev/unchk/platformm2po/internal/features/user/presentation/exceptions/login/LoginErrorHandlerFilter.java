package dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login;

import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

public interface LoginErrorHandlerFilter {

  ExchangeFilterFunction handlerStatusErrorFilter();
}
