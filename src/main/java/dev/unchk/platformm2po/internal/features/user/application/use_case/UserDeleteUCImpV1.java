package dev.unchk.platformm2po.internal.features.user.application.use_case;


import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserDeleteUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDeleteUCImpV1 implements IUserDeleteUC {
    private final UserRepository userRepository;

    @Override
    public String execute(String userId) {
        //------------Excute
      return  userRepository.deleteUserFirebase(userId);
    }
}
