package kwang.likelion.ClassConect.repository;


import kwang.likelion.ClassConect.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
