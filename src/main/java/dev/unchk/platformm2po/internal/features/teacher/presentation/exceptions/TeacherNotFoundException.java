package dev.unchk.platformm2po.internal.features.teacher.presentation.exceptions;


import static dev.unchk.platformm2po.internal.features.teacher.presentation.custom_labels.TeacherCustomLabels.*;
import static dev.unchk.platformm2po.internal.shared.application.custom_labels.SharedCustomLabels.errorMessageNotFound;
import static dev.unchk.platformm2po.internal.shared.application.custom_labels.SharedCustomLabels.getCustomLabels;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException() {
        super(getTeacherCustomLabels("Fr", teacherNotFound));
    }
}
