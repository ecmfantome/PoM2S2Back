package dev.unchk.platformm2po.internal.features.devoir_rendu.presentation.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class DevoirRenduCustomLabels {

    //--------Key Message
    public static final String devoirNotFound = "devoirNotFound";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(devoirNotFound, "Ce devoir n'existe pas.");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(devoirNotFound, "This duty does not exist.");
    }};

    //--------------Translations
    private static final Map<String, Map<String, String>> labels = new HashMap<>() {{
        put("En", labelEn);
        put("Fr", labelFr);
    }};
    ;

    public static String getModuleCustomLabels(String lang, String errorMessage) {
        return labels.get(lang).get(errorMessage);
    }
}
