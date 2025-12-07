package dev.unchk.platformm2po.internal.features.user.application.use_case;


import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserUnLockedUC {
    private final UserRepository userRepository;
    public void execute(String uuid) {
        userRepository.unLockUserFirebase(uuid);
    }

}
