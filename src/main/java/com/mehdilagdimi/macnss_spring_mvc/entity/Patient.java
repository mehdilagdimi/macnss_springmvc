package com.mehdilagdimi.macnss_spring_mvc.entity;

import com.mehdilagdimi.macnss_spring_mvc.base.Person;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patient extends Person {


    @GeneratedValue(strategy = GenerationType.AUTO)
    private long matricule;



    @OneToMany(mappedBy = "patient")
    List<Conjoint> conjointList;

    @OneToMany(mappedBy = "patient")
    List<Folder> foldersList;
}
