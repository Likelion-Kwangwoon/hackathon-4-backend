package kwang.likelion.ClassConect.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Classroom {
    @Id @GeneratedValue
    @Column(name = "class_id")
    private Long id;

    private String name;

    private String professor;

    private String time;

    @ManyToMany(mappedBy = "classlist")
    private List<SiteUser> members = new ArrayList<>();


    //생성 메서드
    public Classroom createClassroom(String name, String professor, String time){
        Classroom classroom = new Classroom();
        classroom.setName(name);
        classroom.setProfessor(professor);
        classroom.setTime(time);
        return classroom;
    }

}
