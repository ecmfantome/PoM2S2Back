package dev.unchk.platformm2po.internal.config.firebase;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import dev.unchk.platformm2po.internal.features.student.presentation.exceptions.StudentNotFoundException;
import dev.unchk.platformm2po.internal.shared.presentation.entities.ErrorResponseApi;
import dev.unchk.platformm2po.internal.shared.presentation.exceptions.IdTokenFirebaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
public class FirebaseJwtDecoder implements ReactiveJwtDecoder {

    @Override
    public Mono<Jwt> decode(String token) {
        return Mono.fromCallable(() -> {
            FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(token);
            // Créer un Jwt avec des claims provenant de Firebase
            Jwt.Builder jwtBuilder = Jwt.withTokenValue(token)
                    .header("kid", firebaseToken.getUid())
                    .claim("sub", firebaseToken.getUid());
//                Map<String, Object> claims = firebaseToken.getClaims();
            return jwtBuilder.build();
        }).onErrorResume(throwable ->Mono.error(new IdTokenFirebaseException()));
    }
}