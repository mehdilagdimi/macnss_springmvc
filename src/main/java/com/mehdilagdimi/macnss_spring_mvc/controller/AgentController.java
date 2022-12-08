package com.mehdilagdimi.macnss_spring_mvc.controller;

import com.mehdilagdimi.macnss_spring_mvc.entity.Agent;
import com.mehdilagdimi.macnss_spring_mvc.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/macnss/agent")
public class AgentController {

    @Autowired
    AgentService agentService;

    @GetMapping("")
    @ResponseBody
    public String index(){
        return "Inside Agent Dashboard!";
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
        return "redirect:/macnss/";
    }
}
