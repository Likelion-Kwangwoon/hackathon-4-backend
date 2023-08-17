package kwang.likelion.ClassConect.service;

import kwang.likelion.ClassConect.domain.Chat;
import kwang.likelion.ClassConect.domain.Message;
import kwang.likelion.ClassConect.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;


    public void create(Chat chat, String content) {
        Message message = new Message();
        message.setContent(content);
        message.setCreateDate(LocalDateTime.now());
        message.setChat(chat);
        this.messageRepository.save(message);
    }
}