package com.example.demoqaspring.controllers;

import com.example.demoqaspring.data.User;
import com.example.demoqaspring.entities.Subject;
import com.example.demoqaspring.repositories.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class MyController {

    SubjectRepository subjectRepository;

    @PostMapping("/hello")
    public String hello(@RequestParam String username, @RequestParam("userage")String ageStr, Model model) {
        try {
            int age = Integer.parseInt(ageStr);
            User user = new User(username, age);
            model.addAttribute("user", user);
            return "hello";
        } catch (NumberFormatException e) {
            model.addAttribute("msg", "User input error - " + ageStr + " is not a number");
            return "error";
        }

    }

    @GetMapping("/subjects")
    public String showSubjects(Model model) {
        List<Subject> subjects = subjectRepository.findAll();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }
}
