package dev.unchk.platformm2po.internal.features.student.presentation.custom_labels;

import java.util.HashMap;
import java.util.Map;

public class StudentCustomLabels {

    //--------Key Message
    public static final String studentNotFound = "studentNotFound";

    //--------------Translation Fr
    private static final Map<String, String> labelFr = new HashMap<>() {{
        put(studentNotFound, "Ce étudiant n'existe pas.");
    }};

    //--------------Translation En
    private static final Map<String, String> labelEn = new HashMap<>() {{
        put(studentNotFound, "This student does not exist.");
    }};

    //--------------Translations
    private static final Map<String, Map<String, String>> labels = new HashMap<>() {{
        put("En", labelEn);
        put("Fr", labelFr);
    }};
    ;

    public static String getStudentCustomLabels(String lang, String errorMessage) {
        return labels.get(lang).get(errorMessage);
    }
}
