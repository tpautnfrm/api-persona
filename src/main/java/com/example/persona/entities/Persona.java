package com.example.persona.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Persona extends Base{

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private int dni;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="persona_libro",
            joinColumns=@JoinColumn(name="persona_id"),
            inverseJoinColumns=@JoinColumn(name="libro_id"))
    private List<Libro> libros = new ArrayList<Libro>();

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="fk_domicilio")
    private Domicilio domicilio;

}
