package dev.unchk.platformm2po.internal.features.user.presentation.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class CustomLabels {

    //--------Key Message
    public static final String userRoleError = "errorMessageRole";
    public static final String userLoginError = "userLoginError";
    public static final String userMailError = "userMailError";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(userRoleError, "Rôle invalide");
        put(userLoginError, "Adresse e-mail ou mot de passe invalide");
        put(userMailError, "L'utilisateur associé à l'adresse e-mail fournie existe déjà (EMAIL_EXISTS).");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(userRoleError, "Invalid Role");
        put(userLoginError, "Invalid email or password");
        put(userMailError, "The user with the provided email already exists (EMAIL_EXISTS).");

    }};

    //--------------Translations
    private static final Map<String, Map<String, String>> labels = new HashMap<>() {{
        put("En", labelEn);
        put("Fr", labelFr);
    }};


    public static String getCustomLabels(String lang, String errorMessage) {
        return labels.get(lang).get(errorMessage);
    }
}
