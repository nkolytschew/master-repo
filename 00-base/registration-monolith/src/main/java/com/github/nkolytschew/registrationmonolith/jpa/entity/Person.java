package com.github.nkolytschew.registrationmonolith.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor // JPA needs a no arg constructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * set the name to unique.
     * Making it possible to refer more easily to {@link Registration}.
     */
    @Column(unique = true)
    private String name;
    /**
     * usually you gonna create a new entity address and use a one-to-many relation here.
     */
    private String address;

    private Date creationDate;
    private Date modificationDate;
}
