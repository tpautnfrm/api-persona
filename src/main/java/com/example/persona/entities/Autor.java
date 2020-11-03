package com.example.persona.entities;

import com.example.persona.repositories.AutorRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name= "autor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Autor extends Base{

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="bibliografia")
    private String bibliografia;
}