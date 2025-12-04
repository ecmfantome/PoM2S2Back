package dev.unchk.platformm2po.internal.features.user.domain.repository;

import com.google.firebase.auth.UserRecord;
import dev.unchk.platformm2po.internal.features.user.application.dto.TokenFirebaseResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.UserRepositoryEntity;
import reactor.core.publisher.Mono;

public interface UserRepository {
 public Mono<TokenFirebaseResponse> signIn(UserRequestSignIn userRequestSignIn);
 public Mono<UserRecord> createUserFirebase(UserRepositoryEntity userJpaEntity);
}
