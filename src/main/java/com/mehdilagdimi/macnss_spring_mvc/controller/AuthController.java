package com.mehdilagdimi.macnss_spring_mvc.controller;

import com.mehdilagdimi.macnss_spring_mvc.base.Person;
import com.mehdilagdimi.macnss_spring_mvc.base.qualifier.LoggedIn;
import com.mehdilagdimi.macnss_spring_mvc.entity.Agent;
import com.mehdilagdimi.macnss_spring_mvc.service.AgentService;
import com.mehdilagdimi.macnss_spring_mvc.service.AuthService;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.NoSuchElementException;


@Controller
@RequestMapping("/auth")
public class AuthController {


    private Person user;

    @Autowired
    @Qualifier(value = "baseUrl")
    private String baseUrl;

    @Autowired
    AuthService authService;


    @GetMapping("/agent")
    public String agentLoginView(Model model){
        model.addAttribute("agent", new Agent());
        return "agentloginPage";
    }
//    @GetMapping("/agentlogin")
//    public String agentlogin(Agent agent){
//        return "agentloginPage";
//    }

    @GetMapping("/patient")
    @ResponseBody
    public String patientLoginView(){
        return "patientloginPage";
    }




    @PostMapping("/agentlogin")
    @ResponseBody
    public String agentLogin(@Validated @ModelAttribute("agent") Agent agent, BindingResult result) {
        if (result.hasErrors()){

        }
        try{
            authService.getAgentByEmail(agent.getEmail());
            this.user = authService.getAgentByEmailAndPassword(agent.getEmail(), agent.getPassword());
//            this.user = agent;
            return ("successful agent email and data .. " + agent.getEmail() + " " + agent.getPassword());

        } catch (NoSuchElementException | NonUniqueResultException | IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
            return "redirect:"+baseUrl+"auth";
        }

    }


    public void logout() {
        user = null;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    @Produces
    @Bean("loggedInUser")
    @LoggedIn
    @SessionScope
    Person getCurrentUser() {
        return user;
    }
}
