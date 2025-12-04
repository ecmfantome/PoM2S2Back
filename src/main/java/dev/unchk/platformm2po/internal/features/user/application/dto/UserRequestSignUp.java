package dev.unchk.platformm2po.internal.features.user.application.dto;


import lombok.Builder;

@Builder
public record UserRequestSignUp (String email, String password){}

