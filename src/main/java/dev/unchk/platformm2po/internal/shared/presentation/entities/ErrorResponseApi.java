package dev.unchk.platformm2po.internal.shared.presentation.entities;

import lombok.Builder;

@Builder
public record ErrorResponseApi(String error,String message) {
}