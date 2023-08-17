package kwang.likelion.ClassConect.repository;

import java.util.Optional;

import kwang.likelion.ClassConect.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);
}