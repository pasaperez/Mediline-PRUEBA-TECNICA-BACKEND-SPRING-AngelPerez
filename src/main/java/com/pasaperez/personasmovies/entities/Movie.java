package com.pasaperez.personasmovies.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends Base{
    private String title;
    private String genre;

    @ManyToOne(optional = false)
    private Persona persona;

}