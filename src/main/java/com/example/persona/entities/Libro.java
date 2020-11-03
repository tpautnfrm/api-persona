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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Libro extends Base{

    @Column(name="titulo")
    private String titulo;

    @Column(name="fecha")
    private int fecha;

    @Column(name="genero")
    private String genero;

    @Column(name="paginas")
    private int paginas;

    @Column(name="autor")
    private String autor;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name="libro_id"),
            inverseJoinColumns = @JoinColumn(name="autor_id")
    )
    private List<Autor> autores;
}
