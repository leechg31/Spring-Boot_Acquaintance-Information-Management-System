package com.project.Information_Management_System.repository;

import com.project.Information_Management_System.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){
        Person person = new Person();

        person.setAge(26);
        person.setName("이성재");
        person.setBloodType("A");

        personRepository.save(person);  //Entity 저장

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("이성재");
        assertThat(people.get(0).getAge()).isEqualTo(26);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");
    }

    @Test
    void allArgsConstructor() {
        Person person1 = new Person(1L,"이성재",26,"몰라도대","A","송파동 161 미성APT 1-505", LocalDate.of(2020,9,4),"학생","010-8805-0632");
    }

    @Test
    void constructTest(){
        Person person2 = new Person("이성재",26,"A");
    }

    @Test
    void hashCodeAndEquals() {
        Person person3_1 = new Person("LeeSungJae",26,"A");
        Person person3_2 = new Person("LeeSungJae",26,"A");

        System.out.println(person3_1.equals(person3_2));
        System.out.println(person3_1.hashCode());
        System.out.println(person3_2.hashCode());

        HashMap<Person,Integer> map = new HashMap<>();
        map.put(person3_1,person3_1.getAge());

        System.out.println(map);
        System.out.println(map.get(person3_2));  //HashCode가 같아야 가져올 수 있음. 즉 완전히 같은 객체여야 가져옴
    }

}