package kwang.likelion.ClassConect.service;

import kwang.likelion.ClassConect.domain.Classroom;
import kwang.likelion.ClassConect.repository.ClassRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClassService {

    private final ClassRepository classRepository;

    public List<Classroom> getList() {
        return this.classRepository.findAll();
    }

    public void create(String name, String professor, String time) {
        Classroom classroom = new Classroom();
        classroom.setName(name);
        classroom.setProfessor(professor);
        classroom.setTime(time);
        this.classRepository.save(classroom);
    }
}
