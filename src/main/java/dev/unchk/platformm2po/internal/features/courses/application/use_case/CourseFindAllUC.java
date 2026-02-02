package dev.unchk.platformm2po.internal.features.courses.application.use_case;

import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseResponse;
import dev.unchk.platformm2po.internal.features.courses.domain.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.courses.application.mapper.CourseMapper.toEntityCoursesResponse;


@AllArgsConstructor
@Service
public class CourseFindAllUC {
    CourseRepository repository;

    public List<CourseResponse> execute() {
        //------Save
        return toEntityCoursesResponse(repository.findAllCourses());
    }
}
