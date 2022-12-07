package com.mehdilagdimi.macnss_spring_mvc.entity;

import com.mehdilagdimi.macnss_spring_mvc.base.Person;

import jakarta.persistence.*;

@Entity
public class Agent extends Person {


    public Agent() {

    }

    public Agent(String fullname, String email, String password) {
        super(fullname, email, password);
    }

}
