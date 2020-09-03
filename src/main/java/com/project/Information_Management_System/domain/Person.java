package com.project.Information_Management_System.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter  //Setting -> Build, Execution, Deployment -> Annotation processors
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue  //command+d -> generation type (Table, Sequence, Identity, Auto) , generator type
    private long id;

    private String name;
    private int age;
    private String hobby;
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private String job;

    @ToString.Exclude
    private String phoneNumber;
}
