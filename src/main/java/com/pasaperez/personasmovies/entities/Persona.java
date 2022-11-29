package com.pasaperez.personasmovies.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona extends Base{
    private String firstName;
    private String lastName;
    private String birthdate;
    private Boolean hasInsurance;
}