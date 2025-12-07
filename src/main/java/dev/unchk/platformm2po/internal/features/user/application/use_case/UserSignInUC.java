package dev.unchk.platformm2po.internal.features.user.application.use_case;


import dev.unchk.platformm2po.internal.features.user.application.dto.UserLoginResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import static dev.unchk.platformm2po.internal.features.user.application.mapper.UserMapper.mapToUserLoginResponse;

@Service
@AllArgsConstructor
public class UserSignInUC {
    private final UserRepository userRepository;

    public Mono<UserLoginResponse> execute(UserRequestSignIn userRequestSignIn) {
        return userRepository.signIn(userRequestSignIn).flatMap(
                stringObjectMap ->
                        Mono.just(mapToUserLoginResponse(stringObjectMap))

        );

    }

}
