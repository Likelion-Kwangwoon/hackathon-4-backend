package kwang.likelion.ClassConect.form;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
