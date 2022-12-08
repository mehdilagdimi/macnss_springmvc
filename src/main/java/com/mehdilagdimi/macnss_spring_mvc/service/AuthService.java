package com.mehdilagdimi.macnss_spring_mvc.service;

import com.mehdilagdimi.macnss_spring_mvc.entity.Agent;
import com.mehdilagdimi.macnss_spring_mvc.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthService {
    @Autowired
    AgentRepository agentRepository;


    @Transactional
    public void saveAgent(Agent agent) {
        agentRepository.save(agent);
    }

    @Transactional
    public Agent getAgentByEmail(String email) {
        return agentRepository.
                findByEmail(email).
                orElseThrow(() -> new NoSuchElementException());
    }

    @Transactional
    public Agent getAgentByEmailAndPassword(String email, String password) throws NoSuchElementException{
        return agentRepository.
                findByEmailAndPassword(email, password).
                orElseThrow(() -> new NoSuchElementException());
    }
//    @Transactional
//    public Agent getAgent(long id) {
//        return agentRepository.
//                findById(id).
//                orElseThrow(() -> new NoSuchElementException());
//    }


}
