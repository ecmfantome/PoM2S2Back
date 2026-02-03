package dev.unchk.platformm2po.internal.features.devoir_rendu.domain.entities;


import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DevoirRendu {
    private String id;
    private String description;
    private String fileName;
    private String contentType;
    private byte[] fileContent;

    private Instant createdAt;

}
