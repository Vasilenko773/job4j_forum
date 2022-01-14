package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;


    public RegControl(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user) {
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}