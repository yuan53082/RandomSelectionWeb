package com.yuan.RandomSelection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yuan.RandomSelection.service.RandomService;

@Controller
@RequestMapping("/")
public class RandomSelection {

    @Autowired
    private RandomService randomsService;

    @PostMapping("/random")
    public ModelAndView Random(@RequestParam("input") String input) {
        String data = randomsService.random(input.split("\n"));
        ModelAndView outputView = new ModelAndView("index");
        outputView.addObject("output", data);
        outputView.addObject("input", input);
        return outputView;
    }

    @PostMapping("/copy")
    public ModelAndView Copy() {

    }

    @PostMapping("/clean")
    public ModelAndView Clean() {
        String c = "";
        ModelAndView cleanView = new ModelAndView("index");
        cleanView.addObject("input", c);
        cleanView.addObject("output", c);
        return cleanView;
    }

    @GetMapping("/test")
    public String test(Model model) {
        // ModelAndView test = new ModelAndView("test");
        // test.addObject("test", "測試");
        // return test;
        model.addAttribute("test", "test");
        return "test";
    }
}
