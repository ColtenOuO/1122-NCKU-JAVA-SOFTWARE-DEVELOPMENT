package com.colten.demo;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SubmitControlloer {
    @PostMapping("/submit")
    public ModelAndView submitTextareas(
        @RequestParam("code1") String code1,
        @RequestParam("code2") String code2) {
            ModelAndView modelAndView = new ModelAndView("result");
            modelAndView.addObject("code1", code1);
            modelAndView.addObject("code2", code2);
            return modelAndView;
        }  
}