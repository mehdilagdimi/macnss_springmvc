package com.mehdilagdimi.macnss_spring_mvc.controller;

import com.mehdilagdimi.macnss_spring_mvc.base.Person;
import com.mehdilagdimi.macnss_spring_mvc.base.qualifier.LoggedIn;
import com.mehdilagdimi.macnss_spring_mvc.entity.Agent;
import com.mehdilagdimi.macnss_spring_mvc.service.AgentService;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;


@Controller
@SessionScope
@RequestMapping("/agent")
public class AgentController {

    @Autowired()
//    @LoggedIn
    @Qualifier("loggedInUser")
    private Person loggedInUser;

    @Autowired
    AuthController authController;
    @Autowired
    AgentService agentService;

    @GetMapping("")
    @ResponseBody
    public String index(){
        if(!authController.isLoggedIn()) return "No user logged in";
        System.out.println(" passed if statement");
        return "Inside Agent Dashboard!" + loggedInUser.getFullname() + loggedInUser.getEmail();
    }

//    @ResponseBody
    @PostMapping("/add")
    public String add(){
        String viewname = "testpage";
        Agent agent = new Agent("agent01", "agent01@gmail.com", "1234");
//        agent.setEmail("agent01@gmail.com");
//        agent.setFullname("agent01@gmail.com");
//        agent.setPassword("1234");
        System.out.println(" inside add method ");
        agentService.saveAgent(agent);
        return "redirect:/macnss";
    }
}
