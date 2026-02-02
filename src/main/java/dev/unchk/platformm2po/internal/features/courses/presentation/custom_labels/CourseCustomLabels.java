package dev.unchk.platformm2po.internal.features.courses.presentation.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class CourseCustomLabels {

    //--------Key Message
    public static final String courseNotFound = "courseNotFound";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(courseNotFound, "Ce course n'existe pas.");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(courseNotFound, "This course does not exist.");
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
