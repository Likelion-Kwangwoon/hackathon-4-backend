package kwang.likelion.ClassConect.form;

import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassForm {
    @NotEmpty(message = "이름은 필수항목입니다.")
    @Size(max=20)
    private String classname;

    @NotEmpty(message = "교수님은 필수항목입니다.")
    @Size(max=10)
    private String professor;

    @NotEmpty(message = "과목 시간은 필수항목입니다.")
    @Size(max=10)
    private String classtime;
}