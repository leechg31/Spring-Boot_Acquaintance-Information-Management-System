package com.project.Information_Management_System.domain;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NoArgsConstructor  //인자가 없는 생성자
@AllArgsConstructor  //모든 데이터를 인자로 갖는 생성자
@RequiredArgsConstructor
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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true /*블럭이 해제되는 순간 블럭이 삭제*/, fetch = FetchType.EAGER  /*fetch를 EAGER 타입으로 진행*/)  //relation
    private Block block;

}
