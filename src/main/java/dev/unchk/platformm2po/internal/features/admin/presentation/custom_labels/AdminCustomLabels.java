package dev.unchk.platformm2po.internal.features.admin.presentation.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class AdminCustomLabels {

    //--------Key Message
    public static final String adminNotFound = "adminNotFound";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(adminNotFound, "Ce administrateur n'existe pas.");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(adminNotFound, "This admin does not exist.");
    }};

    //--------------Translations
    private static final Map<String, Map<String, String>> labels = new HashMap<>() {{
        put("En", labelEn);
        put("Fr", labelFr);
    }};
    ;

    public static String getAdminCustomLabels(String lang, String errorMessage) {
        return labels.get(lang).get(errorMessage);
    }
}
