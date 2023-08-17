package kwang.likelion.ClassConect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/classconnect")
    public String list() {
        return "classconnect";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/classconnect";
    }
}