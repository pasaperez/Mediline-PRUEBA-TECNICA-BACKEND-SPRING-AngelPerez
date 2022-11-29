package com.pasaperez.personasmovies.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona")
public class Persona extends Base{
    @Column(name = "firts_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthdate")
    private String birthdate;
    @Column(name = "has-insurance")
    private Boolean hasInsurance;

}