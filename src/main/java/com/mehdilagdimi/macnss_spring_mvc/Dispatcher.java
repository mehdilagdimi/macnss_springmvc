package com.mehdilagdimi.macnss_spring_mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/macnss")
public class Dispatcher {

    @GetMapping("/index")
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
