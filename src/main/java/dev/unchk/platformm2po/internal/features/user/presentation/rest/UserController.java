package dev.unchk.platformm2po.internal.features.user.presentation.rest;


import com.google.firebase.auth.UserRecord;
import dev.unchk.platformm2po.internal.features.user.application.dto.TokenFirebaseResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.features.user.application.use_case.UserCreateUC;
import dev.unchk.platformm2po.internal.features.user.application.use_case.UserSignInUC;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/user")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserCreateUC userCreateUC;
    private final UserSignInUC userSignInUC;

    @PostMapping("/sign_up")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserRecord> createUser(@RequestBody Mono<UserRequestSignUp> userRequestSignUpMono) {
        return userCreateUC.execute(userRequestSignUpMono);
    }
    @PostMapping("/sign_in")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TokenFirebaseResponse> signIn(@RequestBody Mono<UserRequestSignIn> userRequestSignInMono) {
        return userSignInUC.execute(userRequestSignInMono);
    }
}
