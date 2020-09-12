package com.project.Information_Management_System.service;

import com.project.Information_Management_System.domain.Block;
import com.project.Information_Management_System.domain.Person;
import com.project.Information_Management_System.repository.BlockRepository;
import com.project.Information_Management_System.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {  //BlockRepository와 PersonRepository 연결
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks() {
        List<Person> people = personRepository.findAll();

        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());  //people에서 blocknames만 제외하고 다 가져옴
    }

    public Person getPerson(long id) {
        Person person = personRepository.findById(id).get();

        System.out.println("사람 : "+person);

        return person;
    }
}
