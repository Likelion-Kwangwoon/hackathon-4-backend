package kwang.likelion.ClassConect.controller;

import java.util.List;


import kwang.likelion.ClassConect.service.ClassService;
import kwang.likelion.ClassConect.domain.Classroom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@RequestMapping("/class")
@RequiredArgsConstructor
@Controller
public class ClassController {

    private final ClassService classService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Classroom> classList = this.classService.getList();
        model.addAttribute("classList", classList);
        return "class_list";
    }
}
