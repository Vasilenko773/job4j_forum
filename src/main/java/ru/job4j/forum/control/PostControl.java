package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostControl {

    @Autowired
    private PostService service;

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", service.findByIdPost(id));
        return "/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("post") Post post, HttpServletRequest req) {
        service.saveOrUpdate(post);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "/create";
    }
}
