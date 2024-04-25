package com.colten.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
    @RequestMapping("/MainPage")
    public String index(@RequestParam(value="title", required=false, defaultValue="") String title, Model model) {
        model.addAttribute("name", title);
        return "index";  // src/main/resources/templates/index.html
    }
}
