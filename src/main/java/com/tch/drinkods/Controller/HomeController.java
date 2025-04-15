package com.tch.drinkods.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//首頁視圖控制
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        try {
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; 
        }
    }
}
