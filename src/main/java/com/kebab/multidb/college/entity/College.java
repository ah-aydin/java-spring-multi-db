package com.kebab.multidb.college.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "collegeId")
    int id;
    @Column(name = "collegeName")
    String name;
    @Column(name = "collegeLocation")
    String location;
}