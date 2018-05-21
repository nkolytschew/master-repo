package com.github.nkolytschew.registrationmonolith.jpa.repository;

import com.github.nkolytschew.registrationmonolith.jpa.entity.Registration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

    List<Registration> getAllByPersonName(@Param("personName") String personName);
}
