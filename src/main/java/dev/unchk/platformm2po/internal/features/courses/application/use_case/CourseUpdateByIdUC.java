package dev.unchk.platformm2po.internal.features.courses.application.use_case;

import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseUpdateRequest;
import dev.unchk.platformm2po.internal.features.courses.domain.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.courses.application.mapper.CourseMapper.toEntityCourseUpdate;

@AllArgsConstructor
@Service
public class CourseUpdateByIdUC {
    CourseRepository repository;

    public void execute(CourseUpdateRequest module) {
        //------find
        repository.updateCourseById(toEntityCourseUpdate(module));
    }
}
