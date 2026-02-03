package dev.unchk.platformm2po.internal.features.annonce.application.mapper;

import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceResponse;
import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceSaveRequest;
import dev.unchk.platformm2po.internal.features.annonce.application.dto.AnnonceUpdateRequest;
import dev.unchk.platformm2po.internal.features.annonce.domain.entities.Annonce;
import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;

import java.util.List;

public class AnnonceMapper {

    //----------Mapper to entity
    public static List<Annonce> toEntityAnnoncesSave(List<AnnonceSaveRequest> requests) {
        return requests.stream().map(AnnonceMapper::toEntityAnnonceSave).toList();
    }

    public static List<AnnonceResponse> toEntityAnnoncesResponse(List<Annonce> requests) {
        return requests.stream().map(AnnonceMapper::toEntityAnnonceResponse).toList();
    }

    public static List<Annonce> toEntityAnnoncesUpdate(List<AnnonceUpdateRequest> requests) {
        return requests.stream().map(AnnonceMapper::toEntityAnnonceUpdate).toList();
    }

    //
    public static Annonce toEntityAnnonceSave(AnnonceSaveRequest request) {
        Course course = Course.builder().id(request.courseId()).build();
        return Annonce.builder()
                .titre(request.titre())
                .type(request.type())
                .message(request.message())
                .datePublication(request.datePublication())
                .course(course)
                .build();
    }

    public static AnnonceResponse toEntityAnnonceResponse(Annonce request) {

        return AnnonceResponse.builder()
                .id(request.getId())
                .titre(request.getTitre())
                .type(request.getType())
                .datePublication(request.getDatePublication())
                .message(request.getMessage())
                .course(request.getCourse())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .build();
    }


    //
    public static Annonce toEntityAnnonceUpdate(AnnonceUpdateRequest request) {
        Annonce devoir = Annonce.builder()
                .id(request.id())
                .titre(request.titre())
                .type(request.type())
                .datePublication(request.datePublication())
                .message(request.message())
                .build();
        if (request.courseId() != null) {
            Course course = Course.builder().id(request.courseId()).build();
            devoir.setCourse(course);
        }
        return devoir;
    }

}
