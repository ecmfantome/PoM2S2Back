package dev.unchk.platformm2po.internal.features.teacher.presentation.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class TeacherCustomLabels {

    //--------Key Message
    public static final String teacherNotFound = "teacherNotFound";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(teacherNotFound, "Ce professeur n'existe pas.");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(teacherNotFound, "This teacher does not exist.");
    }};

    //--------------Translations
    private static final Map<String, Map<String, String>> labels = new HashMap<>() {{
        put("En", labelEn);
        put("Fr", labelFr);
    }};
    ;

    public static String getTeacherCustomLabels(String lang, String errorMessage) {
        return labels.get(lang).get(errorMessage);
    }
}
