package com.kebab.multidb.student.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private int id;
    @Column(name = "studentName")
    private String name;
    @Column(name = "studentAge")
    private String age;
}