package dev.unchk.platformm2po.internal.features.user.domain.repository;

import dev.unchk.platformm2po.internal.features.user.application.dto.TokenFirebaseResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<TokenFirebaseResponse> signIn(UserRequestSignIn userRequestSignIn);

    void createUserFirebase(User user);

    String updateClaimsUserFirebase(User user);

    String deleteUserFirebase(String uuid);

    void lockUserFirebase(String uuid);

    void unLockUserFirebase(String uuid);
}
