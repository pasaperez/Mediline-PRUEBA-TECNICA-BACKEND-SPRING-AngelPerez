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
@Table(name = "repositorio")
public class Repositorio extends Base{
    @Column(name = "nombre")
    private String nombre;
}