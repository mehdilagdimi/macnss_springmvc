package com.mehdilagdimi.macnss_spring_mvc.controller;

import com.mehdilagdimi.macnss_spring_mvc.entity.Agent;
import com.mehdilagdimi.macnss_spring_mvc.service.AgentService;
import com.mehdilagdimi.macnss_spring_mvc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@Controller
@RequestMapping("/macnss/auth")
public class AuthController {

    @Autowired
    @Qualifier(value = "baseUrl")
    private String baseUrl;

    @Autowired
    AuthService authService;


    @GetMapping("/agent")
    public String agentLoginView(){
        return "agentloginPage";
    }

    @GetMapping("/patient")
    @ResponseBody
    public String patientLoginView(){
        return "patientloginPage";
    }


    @PostMapping("/agent")
    @ResponseBody
    public String agentLogin(@ModelAttribute("agent") Agent agent) {
        try{
            authService.getAgentByEmail(agent.getEmail());
            return ("successful agent email and data .. " + agent.getEmail() + " " + agent.getPassword());

        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return "redirect:"+baseUrl;
    }

}
