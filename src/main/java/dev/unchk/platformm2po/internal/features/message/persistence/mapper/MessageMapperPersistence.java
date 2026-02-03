package dev.unchk.platformm2po.internal.features.message.persistence.mapper;

import dev.unchk.platformm2po.internal.features.message.domain.entities.Message;
import dev.unchk.platformm2po.internal.features.message.persistence.entities.MessageJpa;

import java.util.List;

public class MessageMapperPersistence {
    //----------Mapper to entity jpa
    public static List<MessageJpa> toMessagesJpa(List<Message> messages) {
        return messages.stream().map(MessageMapperPersistence::toMessageJpa
        ).toList();
    }

    public static MessageJpa toMessageJpa(Message message) {
        return MessageJpa.builder()
                .lu(message.getLu())
                .message(message.getMessage())
                .dateEnvoi(message.getDateEnvoi())
                .build();
    }


    //----------Mapper to entity domain
    public static List<Message> toMessages(List<MessageJpa> messages) {
        return messages.stream().map(MessageMapperPersistence::toMessage).toList();
    }

    //----------Mapper to entity domain
    public static Message toMessage(MessageJpa messageJpa) {
        return Message.builder()
                .id(messageJpa.getId())
                .lu(messageJpa.getLu())
                .message(messageJpa.getMessage())
                .dateEnvoi(messageJpa.getDateEnvoi())
                .createdAt(messageJpa.getCreatedAt())
                .updatedAt(messageJpa.getUpdatedAt())
                .build();
    }
}
