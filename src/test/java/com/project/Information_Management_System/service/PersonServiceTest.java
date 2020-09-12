package com.project.Information_Management_System.service;

import com.project.Information_Management_System.domain.Block;
import com.project.Information_Management_System.domain.Person;
import com.project.Information_Management_System.repository.BlockRepository;
import com.project.Information_Management_System.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {

        givenPeople();

        List<Person> result = personService.getPeopleExcludeBlocks();

        //System.out.println(result);
    }

    @Test
    void cascadeTest() {
        givenPeople();

        List<Person> result = personRepository.findAll();

        System.out.println("\nresult\n");
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        System.out.println("\npersonRepository.findAll\n");
        personRepository.findAll().forEach(System.out::println);
/*
        personRepository.delete(person);
        System.out.println("\npersonRepository.deleteAll\n");
        personRepository.findAll().forEach(System.out::println);

        System.out.println("\nblockRepository.findAll\n");
        blockRepository.findAll().forEach(System.out::println);*/

        System.out.println("\nperson.setBlock(null).findAll\n");
        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
    }

    public void givenBlockPerson(String name, int age,String bloodType) {
        Person blockPerson = new Person(name,age,bloodType);
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);
    }

    private void givenPeople() {

        givenPerson("이성재",26,"A");
        givenPerson("박지수",27,"O");
        givenPerson("전윤재",26,"AB");
        givenBlockPerson("이성재",27,"AB");
    }


    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name,age,bloodType));
    }

}