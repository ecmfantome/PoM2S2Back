package dev.unchk.platformm2po.internal.shared.application.use_case;


import dev.unchk.platformm2po.internal.shared.application.dto.UserRequestSignUp;

public interface IUserSignUpUC {
    void execute(UserRequestSignUp userRequest);

}
