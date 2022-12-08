package com.mehdilagdimi.macnss_spring_mvc.repository;

import com.mehdilagdimi.macnss_spring_mvc.entity.Agent;
import com.mehdilagdimi.macnss_spring_mvc.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository("agentRepository")
//@NoRepositoryBean
public interface AgentRepository extends JpaRepository<Agent, Long> {

    Optional<Agent> findByEmail(String email);
    Optional<Agent> findByEmailAndPassword(String email, String password);
}

