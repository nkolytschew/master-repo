package com.github.nkolytschew.registrationmonolith.service;

import com.github.nkolytschew.registrationmonolith.jpa.entity.Person;

public interface PersonService {
    Person getPersonByName(String name);

    Person savePerson(Person person);

    void deletePerson(Long id);
}
