package dev.unchk.platformm2po.internal.features.message.application.use_case;

import dev.unchk.platformm2po.internal.features.message.application.dto.MessageResponse;
import dev.unchk.platformm2po.internal.features.message.application.dto.MessageSaveRequest;
import dev.unchk.platformm2po.internal.features.message.domain.entities.Message;
import dev.unchk.platformm2po.internal.features.message.domain.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.unchk.platformm2po.internal.features.message.application.mapper.MessageMapper.toEntityMessagesResponse;
import static dev.unchk.platformm2po.internal.features.message.application.mapper.MessageMapper.toEntityMessagesSave;


@AllArgsConstructor
@Service
public class MessageSaveUC {
    MessageRepository repository;

    public List<MessageResponse> execute(List<MessageSaveRequest> requests) {
        //------Mapping
        List<Message> courses = toEntityMessagesSave(requests);
        //------Save And Response
        return toEntityMessagesResponse(repository.saveMessages(courses));
    }
}
