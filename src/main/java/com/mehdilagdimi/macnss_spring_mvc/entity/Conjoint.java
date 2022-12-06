package com.mehdilagdimi.macnss_spring_mvc.entity;

import com.mehdilagdimi.macnss_spring_mvc.base.Person;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conjoint extends Person {


    @OneToMany(mappedBy = "conjoint", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,orphanRemoval = true)
    List<Consultation> consultationList = new ArrayList<>();
}
