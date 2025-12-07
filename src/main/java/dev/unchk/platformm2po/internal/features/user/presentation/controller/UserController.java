package dev.unchk.platformm2po.internal.features.user.presentation.controller;


import dev.unchk.platformm2po.internal.features.user.application.dto.TokenFirebaseResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.application.use_case.UserLockedUC;
import dev.unchk.platformm2po.internal.features.user.application.use_case.UserSignInUC;
import dev.unchk.platformm2po.internal.features.user.application.use_case.UserUnLockedUC;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/user")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserSignInUC userSignInUC;
    private final UserLockedUC userLockedUC;
    private final UserUnLockedUC userUnLockedUC;


    @PostMapping("/sign_in")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TokenFirebaseResponse> signIn(@Valid @RequestBody Mono<UserRequestSignIn> userRequestSignInMono) {
        return userRequestSignInMono.flatMap(
                userSignInUC::execute
        );
    }

    @PutMapping("/lock/{userId}")
    public Mono<ResponseEntity<Void>> lock(@PathVariable String userId) {
        return Mono.fromRunnable(() -> userLockedUC.execute(userId))
                .then(Mono.just(ResponseEntity.ok().build()));
    }

    @PutMapping("/un_lock/{userId}")
    public Mono<ResponseEntity<Void>> unLock(@PathVariable String userId) {
        return Mono.fromRunnable(() -> userUnLockedUC.execute(userId))
                .then(Mono.just(ResponseEntity.ok().build()));
    }
}
