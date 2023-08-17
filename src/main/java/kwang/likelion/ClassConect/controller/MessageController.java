package kwang.likelion.ClassConect.controller;

import kwang.likelion.ClassConect.domain.Chat;
import kwang.likelion.ClassConect.form.MessageForm;
import kwang.likelion.ClassConect.service.ChatService;
import kwang.likelion.ClassConect.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/message")
@RequiredArgsConstructor @Controller
public class MessageController {


    private final ChatService chatService;
    private final MessageService messageService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id,
                               @Valid MessageForm messageForm, BindingResult bindingResult) {
        Chat chat = this.chatService.getChat(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("chat", chat);
            return "chat_detail";
        }
        this.messageService.create(chat, messageForm.getContent());
        return String.format("redirect:/message/detail/%s", id);
    }
}
