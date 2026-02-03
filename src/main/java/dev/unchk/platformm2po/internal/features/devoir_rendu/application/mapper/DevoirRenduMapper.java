package dev.unchk.platformm2po.internal.features.devoir_rendu.application.mapper;

import dev.unchk.platformm2po.internal.features.devoir_rendu.application.dto.DevoirRenduResponse;
import dev.unchk.platformm2po.internal.features.devoir_rendu.application.dto.DevoirRenduSaveRequest;
import dev.unchk.platformm2po.internal.features.devoir_rendu.domain.entities.DevoirRendu;

public class DevoirRenduMapper {
    //
    public static DevoirRendu toEntityDevoirRenduSave(DevoirRenduSaveRequest request) {
        return DevoirRendu.builder()
                .description(request.description())
                .fileContent(request.fileContent())
                .fileName(request.fileName())
                .contentType(request.contentType())
                .build();
    }
    //
    public static DevoirRenduResponse toEntityDevoirRenduResponse(DevoirRendu request) {
        return DevoirRenduResponse.builder()
                .id(request.getId())
                .description(request.getDescription())
                .contentType(request.getContentType())
                .fileContent(request.getFileContent())
                .fileName(request.getFileName())
                .createdAt(request.getCreatedAt())
                .build();
    }
}
