package dev.unchk.platformm2po.internal.features.message.application.use_case;

import dev.unchk.platformm2po.internal.features.message.application.dto.MessageUpdateRequest;
import dev.unchk.platformm2po.internal.features.message.domain.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.unchk.platformm2po.internal.features.message.application.mapper.MessageMapper.toEntityMessageUpdate;


@AllArgsConstructor
@Service
public class MessageUpdateByIdUC {
    MessageRepository repository;

    public void execute(MessageUpdateRequest devoir) {
        //------find
        repository.updateMessageById(toEntityMessageUpdate(devoir));
    }
}
