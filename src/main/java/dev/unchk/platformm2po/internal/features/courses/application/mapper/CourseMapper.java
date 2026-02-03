package dev.unchk.platformm2po.internal.features.courses.application.mapper;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseResponse;
import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseSaveRequest;
import dev.unchk.platformm2po.internal.features.courses.application.dto.CourseUpdateRequest;
import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;

import java.util.List;

public class CourseMapper {

    //----------Mapper to entity
    public static List<Course> toEntityCoursesSave(List<CourseSaveRequest> requests) {
        return requests.stream().map(CourseMapper::toEntityCourseSave).toList();
    }

    public static List<CourseResponse> toEntityCoursesResponse(List<Course> requests) {
        return requests.stream().map(CourseMapper::toEntityCourseResponse).toList();
    }

    public static List<Course> toEntityCoursesUpdate(List<CourseUpdateRequest> requests) {
        return requests.stream().map(CourseMapper::toEntityCourseUpdate).toList();
    }

    //
    public static Course toEntityCourseSave(CourseSaveRequest request) {
        Admin admin = Admin.builder().id(request.adminId()).build();
        Module_ module = Module_.builder().id(request.moduleId()).build();
        return Course.builder()
                .titre(request.titre())
                .description(request.description())
                .semestre(request.semester())
                .module(module)
                .credit(request.credit())
                .createdBy(admin)
                .build();
    }

    public static CourseResponse toEntityCourseResponse(Course request) {

        return CourseResponse.builder()
                .id(request.getId())
                .titre(request.getTitre())
                .description(request.getDescription())
                .semester(request.getSemestre())
                .module(request.getModule())
                .credit(request.getCredit())
                .createdBy(request.getCreatedBy())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .students(request.getStudents())
                .teachers(request.getTeachers())
                .build();
    }


    //
    public static Course toEntityCourseUpdate(CourseUpdateRequest request) {
        Admin admin = Admin.builder().id(request.createdBy()).build();

        Course course = Course.builder()
                .id(request.id())
                .titre(request.titre())
                .description(request.description())
                .credit(request.credit())
                .semestre(request.semester())
                .createdBy(admin)
                .build();
        if (request.moduleId() != null) {
            Module_ module = Module_.builder().id(request.moduleId()).build();
            course.setModule(module);
        }
        return course;
    }

}
