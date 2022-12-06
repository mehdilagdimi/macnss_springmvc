package com.mehdilagdimi.macnss_spring_mvc.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Folder {
    public enum DOCSTATUS{
        EN_ATTENTE,
        REFUSE,
        VALIDE;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long code;
    private Timestamp createdAt = Timestamp.from(Instant.now());
    private long patient_matricule;
    private int nbrConsultation;
    private DOCSTATUS status;
//    private double refundsSum;
    public double totalRefund = 0;

    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Consultation> consultationList = new ArrayList<>();

}
