package com.example.persona.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name= "localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Localidad extends Base{

    @Column(name="denominacion")
    private String denominacion;
}
