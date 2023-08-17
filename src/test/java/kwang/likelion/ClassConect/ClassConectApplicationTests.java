package kwang.likelion.ClassConect;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import kwang.likelion.ClassConect.domain.Classroom;
import kwang.likelion.ClassConect.domain.SiteUser;
import kwang.likelion.ClassConect.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
@Transactional
class ClassConectApplicationTests {

	@Autowired UserRepository userRepository;
	@Test
	@Rollback(value = false)
	void contextLoads() {

		SiteUser person = new SiteUser();
		person.createSiteUser("강평종", "광운대", "pj@naver.com");

		Classroom subject = new Classroom();
		subject.createClassroom("국어", "임재한", "월1");

		person.addClass(subject);

		userRepository.save(person);
	}

}
