package dev.unchk.platformm2po.internal.features.user.application.use_case;


import dev.unchk.platformm2po.internal.features.user.application.dto.TokenFirebaseResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserSignInUC {
    private final UserRepository userRepository;

    public Mono<TokenFirebaseResponse> execute(UserRequestSignIn userRequestSignIn) {
        return userRepository.signIn(userRequestSignIn);
    }

}
