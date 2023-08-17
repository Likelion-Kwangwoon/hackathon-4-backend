package kwang.likelion.ClassConect.service;

import kwang.likelion.ClassConect.domain.SiteUser;
import kwang.likelion.ClassConect.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String name, String school, String username, String password, String email) {
        SiteUser user = new SiteUser();
        user.setName(name);
        user.setSchool(school);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        this.userRepository.save(user);
        return user;
    }
}