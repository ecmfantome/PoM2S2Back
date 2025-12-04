package dev.unchk.platformm2po.internal.config;



import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;



@Service
public class FirebaseJwtDecoder implements ReactiveJwtDecoder {

    @Override
    public Mono<Jwt> decode(String token) {
        return Mono.fromCallable(() -> {
            try {
                FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(token);
                // Créer un Jwt avec des claims provenant de Firebase
                Jwt.Builder jwtBuilder = Jwt.withTokenValue(token)
                        .header("kid", firebaseToken.getUid())
                        .claim("sub", firebaseToken.getUid());

//                Map<String, Object> claims = firebaseToken.getClaims();

                return jwtBuilder.build();
            } catch (FirebaseAuthException e) {
                throw new Exception(e);
            }
        });
    }
}