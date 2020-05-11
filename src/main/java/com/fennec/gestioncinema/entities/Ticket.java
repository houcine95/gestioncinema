package com.fennec.gestioncinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomClient;
    private double prix;
    @Column(unique = true)
    private int codePayement;
    private boolean reservee;

    @ManyToOne @JoinColumn(name = "id_place")
    private Place place;

    @ManyToOne @JoinColumn(name = "id_projection")
    private ProjectionFilm projectionFilm;
}
