package dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import dev.unchk.platformm2po.internal.features.user.application.dto.TokenFirebaseResponse;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignIn;
import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.entities.UserFirebase;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.mapper.UserMapperInfrastructure;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.service.UserServicePersistence;
import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.CustomFirebaseAuthException;
import dev.unchk.platformm2po.internal.features.user.presentation.exceptions.login.LoginErrorHandlerFilter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.mapper.UserMapperInfrastructure.mapToUserFirebaseWithNullValues;
import static dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.service.UserServicePersistence.*;
import static dev.unchk.platformm2po.internal.shared.constant.Constants.*;

@AllArgsConstructor
@Service
public class UserRepositoryImpV1 implements UserRepository {
    private static final String FIREBASE_AUTH_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAr8f-YU5wx10kYk6Qq3vZ-zMisE6FIPNI";
    private final LoginErrorHandlerFilter loginErrorHandlerFilter;
    private final UserServicePersistence userServicePersistence;

    @Override
    public Mono<Map<String, Object>> signIn(UserRequestSignIn userRequestSignIn) {
        Map<String, Object> signInParams = new HashMap<>();
        WebClient webClientFrb = WebClient.builder()
                .baseUrl(FIREBASE_AUTH_URL) // Base URL Firebase
                .filter(loginErrorHandlerFilter.handlerStatusErrorFilter())
                .build();

        return webClientFrb.post()
                .bodyValue(userRequestSignIn)
                .retrieve()
                .bodyToMono(TokenFirebaseResponse.class)
                .flatMap(tokenFirebaseResponse -> {
                    Map<String, Object> claims = getClaimsUserFirebaseByUid(tokenFirebaseResponse.localId());
                    String role = (String) claims.get(CLAIM_ROLE);
                    String userId = (String) claims.get(CLAIM_USER_ID);
                    Map<String, Object> profile = userServicePersistence.getProfileByRole(role, userId);
                    signInParams.put("token", tokenFirebaseResponse);
                    signInParams.put("claims", claims);
                    signInParams.put("role", profile.get("role"));
                    signInParams.put("profile", profile.get("profile"));
                    return Mono.just(signInParams);
                });

    }

    @Override
    public void createUserFirebase(User user) {
        try {
            //--------Mapper
            UserFirebase userFirebase = UserMapperInfrastructure.mapToUserFirebase(user);
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(userFirebase.email)
                    .setEmailVerified(false)
                    .setPassword("passe123")
                    .setDisabled(false);
            UserRecord createdUser = FirebaseAuth.getInstance().createUser(request);
            //-----Mise en place des claims
            Map<String, Object> claims = buildClaimsMap(userFirebase);
            FirebaseAuth.getInstance().setCustomUserClaims(createdUser.getUid(), claims);
            //-----
        } catch (FirebaseAuthException e) {
            throw new CustomFirebaseAuthException(e.getMessage());
        }
    }

    @Override
    public String updateClaimsUserFirebase(User user) {
        try {

            FirebaseAuth auth = FirebaseAuth.getInstance();
            UserRecord userRecord = auth.getUser(user.getUserId());

            Map<String, Object> allClaims = userRecord.getCustomClaims();

            String userId = (String) allClaims.get(CLAIM_USER_ID);
            if (!user.isEmpty()) {//Si rien dans user alors j'update pas les claims
                UserFirebase userFirebase = mapToUserFirebaseWithNullValues(user);
                Map<String, Object> updateClaims = updateClaimsMap(allClaims, userFirebase);
                UserRecord.UpdateRequest updateRequest = new UserRecord.UpdateRequest(userFirebase.userId)
                        .setCustomClaims(updateClaims);
                auth.updateUser(updateRequest);
            }
            return userId;
        } catch (FirebaseAuthException e) {
            System.out.println("[updateClaimsUserFirebase]: " + e.getMessage());
            throw new CustomFirebaseAuthException(e.getMessage());
        }
    }

    @Override
    public String deleteUserFirebase(String uid) {
        try {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            UserRecord userRecord = auth.getUser(uid);
            auth.deleteUser(uid);
            return (String) userRecord.getCustomClaims().get(CLAIM_USER_ID);
        } catch (FirebaseAuthException e) {
            System.out.println("[deleteUserFirebase]: " + e.getMessage());
            throw new CustomFirebaseAuthException(e.getMessage());
        }
    }

    @Override
    public void lockUserFirebase(String uuid) {
        updateUserFirebase(uuid, true);
    }

    @Override
    public void unLockUserFirebase(String uuid) {
        updateUserFirebase(uuid, false);
    }

}
