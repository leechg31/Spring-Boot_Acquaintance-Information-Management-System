package com.project.Information_Management_System.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NoArgsConstructor  //인자가 없는 생성자
@AllArgsConstructor  //모든 데이터를 인자로 갖는 생성자
@Data  // @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 다 포함 -> ctrl + b 로 확인
public class Person {

    @Id
    @GeneratedValue  //command+d -> generation type (Table, Sequence, Identity, Auto) , generator type
    private long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;

    private String address;
    private LocalDate birthday;
    private String job;

    @ToString.Exclude
    private String phoneNumber;
}
