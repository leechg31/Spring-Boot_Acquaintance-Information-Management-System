package com.project.Information_Management_System.repository;

import com.project.Information_Management_System.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
}