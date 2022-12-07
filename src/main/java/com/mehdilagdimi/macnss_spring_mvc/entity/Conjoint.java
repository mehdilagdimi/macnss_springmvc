package com.mehdilagdimi.macnss_spring_mvc.entity;

import com.mehdilagdimi.macnss_spring_mvc.base.Person;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conjoint extends Person {


    @ManyToOne @JoinColumn(name = "patient_matricule", referencedColumnName = "matricule")
    Patient patient;

    @OneToMany(mappedBy = "conjoint", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,orphanRemoval = true)
    List<Consultation> consultationList = new ArrayList<>();


}
