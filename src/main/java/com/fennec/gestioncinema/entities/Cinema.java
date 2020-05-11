package com.fennec.gestioncinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Cinema implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double longitude;
    private double latitude;
    private double altitude;
    private int nombreSalle;

    @ManyToOne @JoinColumn(name = "id_ville")
    private Ville ville;

    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;
}
