package kwang.likelion.ClassConect.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import kwang.likelion.ClassConect.DataNotFoundException;
import kwang.likelion.ClassConect.repository.ChatRepository;
import kwang.likelion.ClassConect.domain.Chat;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRepository chatRepository;

    public List<Chat> getList() {
        return this.chatRepository.findAll();
    }

    public Chat getChat(Integer id) {
        Optional<Chat> question = this.chatRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content) {
        Chat c = new Chat();
        c.setSubject(subject);
        c.setContent(content);
        c.setCreateDate(LocalDateTime.now());
        this.chatRepository.save(c);
    }
}
