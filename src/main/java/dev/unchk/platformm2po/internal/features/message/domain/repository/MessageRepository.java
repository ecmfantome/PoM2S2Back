package dev.unchk.platformm2po.internal.features.message.domain.repository;

import dev.unchk.platformm2po.internal.features.message.domain.entities.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> saveMessages(List<Message> devoirs);
    void updateMessageById(Message devoir);
    void deleteMessageById(String devoirId);
}
