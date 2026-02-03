package dev.unchk.platformm2po.internal.features.message.persistence.repository;

import dev.unchk.platformm2po.internal.features.message.domain.entities.Message;
import dev.unchk.platformm2po.internal.features.message.domain.exceptions.MessageNotFoundException;
import dev.unchk.platformm2po.internal.features.message.domain.repository.MessageRepository;
import dev.unchk.platformm2po.internal.features.message.persistence.entities.MessageJpa;
import dev.unchk.platformm2po.internal.features.message.persistence.jpa.MessageRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.message.persistence.mapper.MessageMapperPersistence.*;


@Service
@AllArgsConstructor
public class MessageRepositoryImpV1 implements MessageRepository {
    private final MessageRepositoryJpa messageRepositoryJpa;

    @Override
    public List<Message> saveMessages(List<Message> messages) {
        List<MessageJpa> messageJpaSave = messageRepositoryJpa.saveAll(toMessagesJpa(messages));
        return toMessages(messageJpaSave);
    }

    @Override
    public void updateMessageById(Message message) {
        MessageJpa existingMessage = messageRepositoryJpa.findById(message.getId())
                .orElseThrow(MessageNotFoundException::new);
        //
        existingMessage.setLu(message.getLu());
        existingMessage.setMessage(message.getMessage());
        //
        messageRepositoryJpa.save(existingMessage);
    }

    @Override
    public void deleteMessageById(String messageId) {
        MessageJpa existingMessage = messageRepositoryJpa.findById(messageId)
                .orElseThrow(MessageNotFoundException::new);
        messageRepositoryJpa.delete(existingMessage);
    }
}
