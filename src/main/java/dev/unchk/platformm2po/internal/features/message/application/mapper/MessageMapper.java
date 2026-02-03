package dev.unchk.platformm2po.internal.features.message.application.mapper;

import dev.unchk.platformm2po.internal.features.message.application.dto.MessageResponse;
import dev.unchk.platformm2po.internal.features.message.application.dto.MessageSaveRequest;
import dev.unchk.platformm2po.internal.features.message.application.dto.MessageUpdateRequest;
import dev.unchk.platformm2po.internal.features.message.domain.entities.Message;
import java.util.List;

public class MessageMapper {

    //----------Mapper to entity
    public static List<Message> toEntityMessagesSave(List<MessageSaveRequest> requests) {
        return requests.stream().map(MessageMapper::toEntityMessageSave).toList();
    }

    public static List<MessageResponse> toEntityMessagesResponse(List<Message> requests) {
        return requests.stream().map(MessageMapper::toEntityMessageResponse).toList();
    }

    public static List<Message> toEntityMessagesUpdate(List<MessageUpdateRequest> requests) {
        return requests.stream().map(MessageMapper::toEntityMessageUpdate).toList();
    }

    //
    public static Message toEntityMessageSave(MessageSaveRequest request) {
        return Message.builder()
                .message(request.message())
                .lu(request.lu())
                .dateEnvoi(request.dateEnvoi())
                .build();
    }

    public static MessageResponse toEntityMessageResponse(Message request) {
        return MessageResponse.builder()
                .id(request.getId())
                .message(request.getMessage())
                .lu(request.getLu())
                .dateEnvoi(request.getDateEnvoi())
                .createdAt(request.getCreatedAt())
                .updatedAt(request.getUpdatedAt())
                .build();
    }

    //
    public static Message toEntityMessageUpdate(MessageUpdateRequest request) {
       return Message.builder()
                .id(request.id())
                .message(request.message())
                .lu(request.lu())
                .build();
    }

}
