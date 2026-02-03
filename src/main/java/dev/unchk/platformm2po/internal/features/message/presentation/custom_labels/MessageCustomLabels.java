package dev.unchk.platformm2po.internal.features.message.presentation.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class MessageCustomLabels {

    //--------Key Message
    public static final String messageNotFound = "messageNotFound";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(messageNotFound, "Ce message n'existe pas.");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(messageNotFound, "This message does not exist.");
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
