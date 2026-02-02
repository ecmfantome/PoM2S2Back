package dev.unchk.platformm2po.internal.features.courses.domain.exceptions;



public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("Course not found");
    }
}
