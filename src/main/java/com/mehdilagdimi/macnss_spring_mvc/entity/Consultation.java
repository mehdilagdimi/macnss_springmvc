package com.mehdilagdimi.macnss_spring_mvc.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Consultation {


    public enum SPECIALITE{
        GENERAL,
        OPHTALMOLOGY,
        CARDIOLOGY
    }

    @Id @GeneratedValue
    private long id;


    private long codeDossier;
    private LocalDate date;
    private int specialite;
    private int montantPaye;

    @Column(nullable = false)
    @Basic(optional = false)
    private boolean isConjoint = false;


    private int numDocuments;

    private double sumConsultationRefund = 0;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conjoint_id", referencedColumnName = "id")
    Conjoint conjoint;


    @OneToMany(mappedBy = "consultation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Document> listDocuments;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) @JoinColumn(name = "folder_id", referencedColumnName = "id")
    Folder folder;
}
