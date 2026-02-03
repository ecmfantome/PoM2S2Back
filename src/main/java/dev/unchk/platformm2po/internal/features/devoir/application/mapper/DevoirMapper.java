package dev.unchk.platformm2po.internal.features.devoir.application.mapper;

import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirResponse;
import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirSaveRequest;
import dev.unchk.platformm2po.internal.features.devoir.application.dto.DevoirUpdateRequest;
import dev.unchk.platformm2po.internal.features.devoir.domain.entities.Devoir;

import java.util.List;

public class DevoirMapper {

    //----------Mapper to entity
    public static List<Devoir> toEntityDevoirsSave(List<DevoirSaveRequest> requests) {
        return requests.stream().map(DevoirMapper::toEntityDevoirSave).toList();
    }

    public static List<DevoirResponse> toEntityDevoirsResponse(List<Devoir> requests) {
        return requests.stream().map(DevoirMapper::toEntityDevoirResponse).toList();
    }

    public static List<Devoir> toEntityDevoirsUpdate(List<DevoirUpdateRequest> requests) {
        return requests.stream().map(DevoirMapper::toEntityDevoirUpdate).toList();
    }

    //
    public static Devoir toEntityDevoirSave(DevoirSaveRequest request) {
        Course course = Course.builder().id(request.courseId()).build();
        return Devoir.builder()
                .titre(request.titre())
                .consigne(request.consigne())
                .dateLimite(request.dateLimite())
                .course(course)
                .build();
    }

    public static DevoirResponse toEntityDevoirResponse(Devoir request) {

        return DevoirResponse.builder()
                .id(request.getId())
                .titre(request.getTitre())
                .consigne(request.getConsigne())
                .dateLimite(request.getDateLimite())
                .course(request.getCourse())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .build();
    }


    //
    public static Devoir toEntityDevoirUpdate(DevoirUpdateRequest request) {

        Devoir devoir = Devoir.builder()
                .id(request.id())
                .titre(request.titre())
                .consigne(request.consigne())
                .dateLimite(request.dateLimite())
                .build();
        if (request.courseId() != null) {
            Course course = Course.builder().id(request.courseId()).build();
            devoir.setCourse(course);
        }
        return devoir;
    }

}
