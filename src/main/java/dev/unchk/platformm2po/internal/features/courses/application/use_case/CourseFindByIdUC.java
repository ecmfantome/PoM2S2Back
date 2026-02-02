package dev.unchk.platformm2po.internal.features.courses.application.use_case;

import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseResponse;
import dev.unchk.platformm2po.internal.features.courses.domain.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.courses.application.mapper.CourseMapper.toEntityCourseResponse;


@AllArgsConstructor
@Service
public class CourseFindByIdUC {
    CourseRepository repository;

    public CourseResponse execute(String moduleId) {
        //------find
        return toEntityCourseResponse(repository.findCourseById(moduleId));
    }
}
