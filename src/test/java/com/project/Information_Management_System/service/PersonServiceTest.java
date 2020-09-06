package com.project.Information_Management_System.service;

import com.project.Information_Management_System.domain.Block;
import com.project.Information_Management_System.domain.Person;
import com.project.Information_Management_System.repository.BlockRepository;
import com.project.Information_Management_System.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

        System.out.println(result);
    }

    public void givenBlockPerson(String name, int age,String bloodType) {
        Person blockPerson = new Person(name,age,bloodType);
        blockPerson.setBlock(givenBlock(name));

        personRepository.save(blockPerson);
    }

    private void givenBlocks() {
        givenBlock("이성재");
    }

    private void givenPeople() {

        givenPerson("이성재",26,"A");
        givenPerson("박지수",27,"O");
        givenPerson("전기태",28,"AB");
        givenBlockPerson("이성재",27,"AB");
    }

    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name,age,bloodType));
    }
}