package dev.unchk.platformm2po.internal.shared.application.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class SharedCustomLabels {

    //--------Key Message
    public static final String errorMessageRole = "errorMessageRole";
    public static final String errorMessageNotFound = "errorMessageRole";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(errorMessageRole, "Rôle invalide");
        put(errorMessageNotFound, "Ce professeur n'existe pas.");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(errorMessageRole, "Invalid Role");
        put(errorMessageNotFound, "This professor does not exist.");
    }};

    //--------------Translations
    private static final Map<String, Map<String, String>> labels = new HashMap<>() {{
        put("En", labelEn);
        put("Fr", labelFr);
    }};
    ;

    public static String getCustomLabels(String lang, String errorMessage) {
        return labels.get(lang).get(errorMessage);
    }
}
