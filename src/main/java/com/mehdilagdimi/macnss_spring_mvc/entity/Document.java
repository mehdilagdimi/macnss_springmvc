package com.mehdilagdimi.macnss_spring_mvc.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Document {

    private enum DOCTYPE{
        MEDICAMENT,
        ANALYSE,
        IMAGERIE
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate date;

    private float montantPaye;
    private DOCTYPE docType;

    public float percentage;


    private String nom;



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    Consultation consultation;

}
