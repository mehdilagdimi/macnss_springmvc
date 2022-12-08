package com.mehdilagdimi.macnss_spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping("")
    public String hello(){
        String viewname = "index";
        return viewname;
    }

//    @ResponseBody
    @GetMapping("/testpage")
    public String index2(){
        String viewname = "testpage";
        return viewname;
    }
}
