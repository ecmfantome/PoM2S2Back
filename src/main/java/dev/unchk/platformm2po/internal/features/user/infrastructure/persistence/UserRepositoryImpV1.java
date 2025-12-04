package dev.unchk.platformm2po.internal.features.user.infrastructure.persistence;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import dev.unchk.platformm2po.internal.features.user.application.dto.TokenFirebaseResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@Service
public class UserRepositoryImpV1 implements UserRepository {
    private static final String FIREBASE_AUTH_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAr8f-YU5wx10kYk6Qq3vZ-zMisE6FIPNI";

    @Override
    public Mono<TokenFirebaseResponse> signIn(UserRequestSignIn userRequestSignIn) {
        WebClient webClientFrb = WebClient.builder()
                .baseUrl(FIREBASE_AUTH_URL) // Base URL Firebase
//                    .filter(errorHandlingFilter.errorHandlingFilter())
                .build();

        return webClientFrb.post()
                .bodyValue(userRequestSignIn)
                .retrieve()
                .bodyToMono(TokenFirebaseResponse.class)
                .onErrorResume(Mono::error);

    }

    @Override
    public Mono<UserRecord> createUserFirebase(UserRepositoryEntity userJpaEntity) {
        return Mono.fromCallable(() -> {
                    UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                            .setEmail(userJpaEntity.getEmail())
                            .setEmailVerified(false)
                            .setPassword(userJpaEntity.getPassword())
                            .setDisabled(false);

                    // Ajouter des claims personnalisés si nécessaire
//                    if (userJpaEntity.getCustomClaims() != null) {
//                        // Les claims seront définis après la création
//                    }

                    return FirebaseAuth.getInstance().createUser(request);
                })
                .subscribeOn(Schedulers.boundedElastic());
    }
}
