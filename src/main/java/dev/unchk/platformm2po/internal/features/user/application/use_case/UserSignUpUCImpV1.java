package dev.unchk.platformm2po.internal.features.user.application.use_case;


import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;
import dev.unchk.platformm2po.internal.features.user.application.mapper.UserMapper;
import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserSignUpUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSignUpUCImpV1 implements IUserSignUpUC {
    private final UserRepository userRepository;

    public void execute(UserRequestSignUp userRequest)  {
        //------------Mapper
        User user = UserMapper.mapToUser(userRequest);
        //------------Excute
         userRepository.createUserFirebase(user);
    }

}
