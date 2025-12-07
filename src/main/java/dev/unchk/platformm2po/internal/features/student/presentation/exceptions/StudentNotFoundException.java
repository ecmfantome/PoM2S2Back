package dev.unchk.platformm2po.internal.features.student.presentation.exceptions;


import static dev.unchk.platformm2po.internal.features.student.presentation.custom_labels.StudentCustomLabels.getStudentCustomLabels;
import static dev.unchk.platformm2po.internal.features.student.presentation.custom_labels.StudentCustomLabels.studentNotFound;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super(getStudentCustomLabels("Fr", studentNotFound));
    }
}
