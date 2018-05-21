package com.github.nkolytschew.registrationmonolith.jpa.repository;

import com.github.nkolytschew.registrationmonolith.jpa.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> getPersonByName(@Param("name") String name);

    Boolean existsByName(@Param("name") String name);
}
