package com.fennec.gestioncinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ProjectionFilm implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private double prix;

    @OneToMany(mappedBy = "projectionFilm")
    private Collection<Ticket> tickets;

    @ManyToOne @JoinColumn(name = "id_film")
    private Film film;

    @ManyToOne @JoinColumn(name = "id_salle")
    private Salle salle;

    @ManyToOne @JoinColumn(name = "id_seance")
    private Seance seance;
}
