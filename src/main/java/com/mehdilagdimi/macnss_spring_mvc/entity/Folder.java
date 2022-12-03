package com.mehdilagdimi.macnss_spring_mvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Folder {
    @Id @GeneratedValue
    private long id;
}
