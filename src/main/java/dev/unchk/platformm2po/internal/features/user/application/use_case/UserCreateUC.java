package dev.unchk.platformm2po.internal.features.user.application.use_case;


import com.google.firebase.auth.UserRecord;
import dev.unchk.platformm2po.internal.features.user.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.features.user.application.mapper.UserMapper;
import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import dev.unchk.platformm2po.internal.features.user.infrastructure.persistence.UserRepositoryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserCreateUC {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public Mono<UserRecord> execute(Mono<UserRequestSignUp> userRequestSignUpMono) {
        return userRequestSignUpMono.flatMap(userRequest -> {
            //------------Mapper
            User user = userMapper.mapToUser(userRequest);
            UserRepositoryEntity userRepositoryEntity = userMapper.mapToUserJpa(user);

            //------------Excute
            return userRepository.createUserFirebase(userRepositoryEntity);

        });

    }

}
