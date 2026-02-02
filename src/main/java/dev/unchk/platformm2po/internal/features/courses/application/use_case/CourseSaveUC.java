package dev.unchk.platformm2po.internal.features.courses.application.use_case;

import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseResponse;
import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseSaveRequest;
import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import dev.unchk.platformm2po.internal.features.courses.domain.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.courses.application.mapper.CourseMapper.toEntityCoursesResponse;
import static dev.unchk.platformm2po.internal.features.courses.application.mapper.CourseMapper.toEntityCoursesSave;


@AllArgsConstructor
@Service
public class CourseSaveUC {
    CourseRepository repository;

    public List<CourseResponse> execute(List<CourseSaveRequest> requests) {
        //------Mapping
        List<Course> courses = toEntityCoursesSave(requests);
        //------Save And Response
        return toEntityCoursesResponse(repository.saveCourses(courses));
    }
}
