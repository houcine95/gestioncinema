package com.fennec.gestioncinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Salle implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombrePlace;

    @ManyToOne @JoinColumn(name = "id_cinema")
    private Cinema cinema;

    @OneToMany(mappedBy = "salle")
    private Collection<Place> places;

    @OneToMany(mappedBy = "salle")
    private Collection<ProjectionFilm> projectionFilms;
}
