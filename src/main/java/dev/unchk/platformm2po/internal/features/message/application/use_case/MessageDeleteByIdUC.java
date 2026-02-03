package dev.unchk.platformm2po.internal.features.message.application.use_case;

import dev.unchk.platformm2po.internal.features.message.domain.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageDeleteByIdUC {
    MessageRepository repository;

    public void execute(String messageId) {
        //------delete
        repository.deleteMessageById(messageId);
    }
}
