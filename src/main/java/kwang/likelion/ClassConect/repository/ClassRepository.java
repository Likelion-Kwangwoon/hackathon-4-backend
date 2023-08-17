package kwang.likelion.ClassConect.repository;

import kwang.likelion.ClassConect.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classroom, Long> {

}
