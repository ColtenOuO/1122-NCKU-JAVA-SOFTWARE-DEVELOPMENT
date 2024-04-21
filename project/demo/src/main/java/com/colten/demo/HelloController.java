package com.colten.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @RequestMapping("/MainPage")
    public String index(@RequestParam(value="title", required=false, defaultValue="xiao") String title, Model model) {
        model.addAttribute("name", title);
        return "index";  // 使用 src/main/resources/templates/index.html 模板
        
    }
}

