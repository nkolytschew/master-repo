package com.github.nkolytschew.registrationmonolith.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor // JPA needs a no arg constructor
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    /**
     * Usually you gonna create a new entity {@link Person} and use a one-to-many relation here.
     * To keep it simple, we just use the {@link Person#name} here and maybe map it later.
     */
    private String personName;

    private Date creationDate;
    private Date modificationDate;
}
