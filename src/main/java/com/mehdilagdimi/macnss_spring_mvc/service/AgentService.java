package com.mehdilagdimi.macnss_spring_mvc.service;

import com.mehdilagdimi.macnss_spring_mvc.entity.Agent;
import com.mehdilagdimi.macnss_spring_mvc.repository.AgentRepository;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AgentService {
    @Autowired
    AgentRepository agentRepository;

    @Transactional
    public List<Agent> getAgent() {
        return agentRepository.findAll();
    }

    @Transactional
    public void saveAgent(Agent agent) {
        agentRepository.save(agent);
    }

    @Transactional
    public Agent getAgent(long id) {
        return agentRepository.
                findById(id).
                orElseThrow(() -> new NoSuchElementException());
    }

    @Transactional
    public void deleteAgent(long id) {
        agentRepository.deleteById(id);
    }

}
