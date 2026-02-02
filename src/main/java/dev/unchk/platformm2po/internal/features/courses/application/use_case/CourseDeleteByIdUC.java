package dev.unchk.platformm2po.internal.features.courses.application.use_case;

import dev.unchk.platformm2po.internal.features.courses.domain.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseDeleteByIdUC {
    CourseRepository repository;

    public void execute(String moduleId) {
        //------delete
        repository.deleteCourseById(moduleId);
    }
}
