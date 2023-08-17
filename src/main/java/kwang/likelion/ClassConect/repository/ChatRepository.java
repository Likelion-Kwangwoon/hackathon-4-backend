package kwang.likelion.ClassConect.repository;

import java.util.List;

import kwang.likelion.ClassConect.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Chat findBySubject(String subject);
    Chat findBySubjectAndContent(String subject, String content);
    List<Chat> findBySubjectLike(String subject);
}