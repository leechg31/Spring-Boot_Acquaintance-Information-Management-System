package com.project.Information_Management_System.repository;

import com.project.Information_Management_System.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {


}
