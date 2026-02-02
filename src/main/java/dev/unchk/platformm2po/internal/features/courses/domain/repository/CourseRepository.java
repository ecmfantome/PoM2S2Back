package dev.unchk.platformm2po.internal.features.courses.domain.repository;

import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> saveCourses(List<Course> modules);

    List<Course> findAllCourses();

    Course findCourseById(String moduleId);

    void updateCourseById(Course module);

    void deleteCourseById(String moduleId);
}
