package dev.unchk.platformm2po.internal.features.message.domain.entities;


import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    private String id;
    private String message;
    private Boolean lu;
    private Instant dateEnvoi;
    private Instant createdAt;
    private Instant updatedAt;
}
