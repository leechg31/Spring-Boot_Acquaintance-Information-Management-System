package com.project.Information_Management_System.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter  //Setting -> Build, Execution, Deployment -> Annotation processors
@Setter
@ToString
@NoArgsConstructor  //인자가 없는 생성자
@AllArgsConstructor  //모든 데이터를 인자로 갖는 생성자
@RequiredArgsConstructor  //@NonNull인 args만 인자로가지는 생성자
public class Person {

    @Id
    @GeneratedValue  //command+d -> generation type (Table, Sequence, Identity, Auto) , generator type
    private long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private String job;

    @ToString.Exclude
    private String phoneNumber;

    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }

        Person person = (Person) object;

        if(!person.getName().equals(this.name)) {
            return false;
        }

        if(person.getAge() != this.age) {
            return false;
        }

        return true;
    }
}
