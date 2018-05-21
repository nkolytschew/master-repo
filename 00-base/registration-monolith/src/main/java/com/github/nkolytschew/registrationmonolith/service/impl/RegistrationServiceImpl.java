package com.github.nkolytschew.registrationmonolith.service.impl;

import com.github.nkolytschew.registrationmonolith.jpa.entity.Person;
import com.github.nkolytschew.registrationmonolith.jpa.entity.Registration;
import com.github.nkolytschew.registrationmonolith.jpa.repository.RegistrationRepository;
import com.github.nkolytschew.registrationmonolith.service.PersonService;
import com.github.nkolytschew.registrationmonolith.service.RegistrationService;
import com.github.nkolytschew.registrationmonolith.web.model.RegistrationModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final PersonService personService;
    private final RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(PersonService personService, RegistrationRepository registrationRepository) {
        this.personService = personService;
        this.registrationRepository = registrationRepository;
    }


    /**
     * Find a {@link Registration} by a given id.
     * If there is no such {@link Registration} throw an {@link IllegalArgumentException} instead.
     *
     * @param id {@link Long}
     * @return populated {@link RegistrationModel}
     */
    @Override
    public RegistrationModel getRegistrationById(Long id) {
        final Registration registration = this.registrationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Registration found with id = " + id));
        return this.mapToRegistrationModel(registration, this.personService.getPersonByName(registration.getPersonName()));
    }

    @Override
    public RegistrationModel updateRegistration(Long id, RegistrationModel model) {
        final Registration registration = this.mapToRegistrationFromRegistrationModel(model);
        registration.setId(id);
        registration.setModificationDate(new Date());

        this.registrationRepository.save(registration);
        this.personService.savePerson(this.mapToPersonFromRegistrationModel(model));
        return model;
    }

    @Override
    public RegistrationModel createRegistration(RegistrationModel model) {
        final Registration registration = this.mapToRegistrationFromRegistrationModel(model);
        registration.setCreationDate(new Date());

        this.registrationRepository.save(registration);
        this.personService.savePerson(this.mapToPersonFromRegistrationModel(model));

        return model;
    }

    /**
     * Delete a {@link Registration} and its corresponding {@link Person}.
     * Return the deleted Registration to show, what was deleted.
     * Throw an {@link IllegalArgumentException}, if there is no such id.
     *
     * @param id {@link Long}
     * @return the deleted {@link RegistrationModel}
     */
    @Override
    public RegistrationModel deleteRegistration(Long id) {
        final Registration registration = this.registrationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No Registration found with id = " + id));
        final Person person = this.personService.getPersonByName(registration.getPersonName());
        this.registrationRepository.deleteById(id);
        this.personService.deletePerson(person.getId());
        return this.mapToRegistrationModel(registration, person);
    }

    /**
     * Get all {@link Registration} from Database and map to {@link RegistrationModel}.
     *
     * @return populated {@link RegistrationModel}
     */
    @Override
    public List<RegistrationModel> getAllRegistrations() {
        List<RegistrationModel> registrationModelList = new ArrayList<>();
        this.registrationRepository.findAll().forEach(registration -> {
            registrationModelList.add(this.mapToRegistrationModel(registration, this.personService.getPersonByName(registration.getPersonName())));
        });
        return registrationModelList;
    }

    // helper

    /**
     * A helper functions to map from {@link Registration} and {@link Person} to {@link RegistrationModel}.
     * Please keep in mind that this helper are used in this simplified context. In a <b>real</b> application you should use a BeanMapper.
     *
     * @param registration {@link Registration} values from Database to map from
     * @param person       {@link Person} values from Database to map from
     * @return a populated {@link RegistrationModel}
     */
    private RegistrationModel mapToRegistrationModel(Registration registration, Person person) {
        final RegistrationModel registrationModel = new RegistrationModel();
        if (registration != null) {
            registrationModel.setRegistrationName(registration.getName());
            registrationModel.setRegistrationDescription(registration.getDescription());
        }
        if (person != null) {
            registrationModel.setUserName(person.getName());
            registrationModel.setAddress(person.getAddress());
        }
        return registrationModel;
    }

    /**
     * A helper functions to map from {@link RegistrationModel} to {@link Registration}.
     * Please keep in mind that this helper are used in this simplified context. In a <b>real</b> application you should use a BeanMapper.
     *
     * @param model {@link RegistrationModel} from the {@link com.github.nkolytschew.registrationmonolith.web.rest.RegistrationController}
     * @return a populated {@link Registration}
     */
    private Registration mapToRegistrationFromRegistrationModel(RegistrationModel model) {
        final Registration registration = new Registration();
        if (model != null) {
            registration.setName(model.getRegistrationName());
            registration.setDescription(model.getRegistrationDescription());
            registration.setPersonName(model.getUserName());
        }
        return registration;
    }

    /**
     * A helper functions to map from {@link RegistrationModel} to {@link Person}.
     * Please keep in mind that this helper are used in this simplified context. In a <b>real</b> application you should use a BeanMapper.
     *
     * @param model {@link RegistrationModel} from the {@link com.github.nkolytschew.registrationmonolith.web.rest.RegistrationController}
     * @return a populated {@link Person}
     */
    private Person mapToPersonFromRegistrationModel(RegistrationModel model) {
        final Person person = new Person();
        if (model != null) {
            person.setName(model.getUserName());
            person.setAddress(model.getAddress());
        }
        return person;
    }
}
