package com.github.nkolytschew.registrationmonolith.service.impl;

import com.github.nkolytschew.registrationmonolith.jpa.entity.Person;
import com.github.nkolytschew.registrationmonolith.jpa.repository.PersonRepository;
import com.github.nkolytschew.registrationmonolith.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Get a {@link Person} by name. If there is no such {@link Person} return a empty {@link Person}.
     *
     * @param name {@link String}
     * @return populated {@link Person}
     */
    @Override
    public Person getPersonByName(String name) {
        return this.personRepository.getPersonByName(name)
                .orElseGet(Person::new);
    }

    @Override
    public Person savePerson(Person person) {
        final Optional<Person> p = this.personRepository.getPersonByName(person.getName());
        if (p.isPresent()) {
            person.setId(p.get().getId());
            person.setCreationDate(p.get().getCreationDate());
            person.setModificationDate(new Date());
        } else {
            person.setCreationDate(new Date());
        }
        return this.personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }
}
