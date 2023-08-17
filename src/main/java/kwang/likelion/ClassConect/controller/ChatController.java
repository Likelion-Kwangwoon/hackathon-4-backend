package kwang.likelion.ClassConect.controller;

import java.util.List;

import kwang.likelion.ClassConect.domain.Chat;
import kwang.likelion.ClassConect.form.ChatForm;
import kwang.likelion.ClassConect.form.MessageForm;
import kwang.likelion.ClassConect.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/chat")
@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Chat> chatList = this.chatService.getList();
        model.addAttribute("chatList", chatList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, MessageForm messageForm) {
        Chat chat = this.chatService.getChat(id);
        model.addAttribute("chat", chat);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(ChatForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid ChatForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.chatService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/chat/list";
    }
}
