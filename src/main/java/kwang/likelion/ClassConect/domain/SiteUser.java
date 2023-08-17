package kwang.likelion.ClassConect.domain;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class SiteUser {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String school;

    private String username;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(name = "member_class",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<Classroom> classlist = new ArrayList<>();


    //생성 메서드
    public SiteUser(){}
    public SiteUser createSiteUser(String name, String school, String email){
        SiteUser siteUser = new SiteUser();
        siteUser.setName(name);
        siteUser.setSchool(school);
        siteUser.setEmail(email);
        return siteUser;
    }
}
