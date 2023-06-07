package com.example.thymeleaf_demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "传递的标题");
        model.addAttribute("description", "传递的description");
        model.addAttribute("keywords", "传递的keywords");
        return "index";
    }
}
