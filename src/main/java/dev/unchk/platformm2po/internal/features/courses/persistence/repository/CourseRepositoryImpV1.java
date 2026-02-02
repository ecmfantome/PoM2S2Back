package dev.unchk.platformm2po.internal.features.courses.persistence.repository;

import dev.unchk.platformm2po.internal.features.courses.domain.exceptions.CourseNotFoundException;
import dev.unchk.platformm2po.internal.features.courses.persistence.entities.CourseJpa;
import dev.unchk.platformm2po.internal.features.courses.persistence.jpa.CourseRepositoryJpa;
import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import dev.unchk.platformm2po.internal.features.courses.domain.repository.CourseRepository;
import dev.unchk.platformm2po.internal.features.module.infrastructure.persistence.entities.ModuleJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.courses.persistence.mapper.CourseMapperPersistence.*;

@Service
@AllArgsConstructor
public class CourseRepositoryImpV1 implements CourseRepository {
    private final CourseRepositoryJpa courseRepositoryJpa;

    @Override
    public List<Course> saveCourses(List<Course> courses) {
        List<CourseJpa> courseJpaSave = courseRepositoryJpa.saveAll(toCoursesJpa(courses));
        return toCourses(courseJpaSave);
    }

    @Override
    public List<Course> findAllCourses() {
        return toCourses(courseRepositoryJpa.findAll());
    }

    @Override
    public Course findCourseById(String courseId) {
        CourseJpa existingCourse = courseRepositoryJpa.findById(courseId)
                .orElseThrow(CourseNotFoundException::new);
        return toCourse(existingCourse);
    }

    @Override
    public void updateCourseById(Course course) {
        CourseJpa existingCourse = courseRepositoryJpa.findById(course.getId())
                .orElseThrow(CourseNotFoundException::new);
        //
        existingCourse.setTitre(course.getTitre());
        existingCourse.setSemester(course.getSemestre());
        existingCourse.setCredits(course.getCredit());
        if (course.getModule() != null && course.getModule().getId() != null) {
            existingCourse.setModuleJpa(ModuleJpa.builder().id(course.getModule().getId()).build());
        }
        //
        courseRepositoryJpa.save(existingCourse);
    }

    @Override
    public void deleteCourseById(String courseId) {
        CourseJpa existingCourse = courseRepositoryJpa.findById(courseId)
                .orElseThrow(CourseNotFoundException::new);
        courseRepositoryJpa.delete(existingCourse);
    }


}
