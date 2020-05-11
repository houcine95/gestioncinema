package com.fennec.gestioncinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Place implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private double longitude;
    private double latitude;
    private double altitude;

    @ManyToOne @JoinColumn(name = "id_salle")
    private Salle salle;

    @OneToMany(mappedBy = "place")
    private Collection<Ticket> tickets;
}
