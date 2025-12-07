package dev.unchk.platformm2po.internal.features.user.application.use_case;

import dev.unchk.platformm2po.internal.features.user.domain.entities.User;
import dev.unchk.platformm2po.internal.features.user.domain.repository.UserRepository;
import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestUpdateClaims;
import dev.unchk.platformm2po.internal.shared.application.use_case.IUserUpdateClaimsUC;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.user.application.mapper.UserMapper.mapToUserWithNullValues;

@Service
@AllArgsConstructor
public class UserUpdateClaimsUC implements IUserUpdateClaimsUC {
    private final UserRepository userRepository;


    @Override
    public String execute(UserRequestUpdateClaims userRequestUpdateClaims) {
        User user = mapToUserWithNullValues(userRequestUpdateClaims);
        return userRepository.updateClaimsUserFirebase(user);
    }
}

