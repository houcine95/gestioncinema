package com.fennec.gestioncinema.service;

import com.fennec.gestioncinema.dao.*;
import com.fennec.gestioncinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

//@Bean
public class cinemaInitServiceImp implements ICinemaInitService {

    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    PlaceRepository placeRepository;
    @Autowired
    ProjectionFilmRepository projectionFilmRepository;
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    SeanceRepository seanceRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    VilleRepository villeRepository;
    @Autowired

    @Override
    public void initCategories() {
        Stream.of("Action", "Aventure", "Drama").forEach(c ->{
            Categorie cat = new Categorie();
            cat.setName(c);
            categorieRepository.save(cat);
        });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(v ->{
            Stream.of("Kawakib", "EL Falah", "Megarama").forEach(c ->{
                Cinema cinm = new Cinema();
                cinm.setName(c);
                cinm.setNombreSalle(3+(int)(Math.random()*9));
                cinm.setVille(v);
                cinemaRepository.save(cinm);
            });
        });
    }

    @Override
    public void initFilms() {
        Categorie c1 = categorieRepository.findAll().get(0);
        Film f1 = new Film();
        f1.setCategorie(c1);
        f1.setDuree(2.32);
        f1.setRealisateur("Christopher Nolan");
        f1.setTitre("Dark Knight");
        filmRepository.save(f1);
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(s ->{
            Stream.of(1,2,3,4,5,6,7).forEach(p->{
                Place place = new Place();
                place.setNumero(p);
                place.setSalle(s);
                placeRepository.save(place);
            });
        });
    }

    @Override
    public void initProjectionFilms() {
        Film film = filmRepository.findAll().get(0);
        Salle salle = salleRepository.findAll().get(0);
        Seance seance = seanceRepository.findAll().get(0);
        ProjectionFilm projectionFilm = new ProjectionFilm();
        projectionFilm.setDateProjection(seance.getHeureDebut());
        projectionFilm.setFilm(film);
        projectionFilm.setSalle(salle);
        projectionFilm.setSeance(seance);
        projectionFilmRepository.save(projectionFilm);
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(c ->{
            Salle salle = new Salle();
            salle.setCinema(c);
            salle.setNombrePlace(c.getNombreSalle());
            salle.setName("S1");
            salle.setNombrePlace(50);
            salleRepository.save(salle);
        });
    }

    @Override
    public void initSeances() {
        Seance seance = new Seance();
        seance.setHeureDebut(new Date());
        seanceRepository.save(seance);
    }

    @Override
    public void initTickets() {
        ProjectionFilm projectionFilm = projectionFilmRepository.findAll().get(0);
        Place place = placeRepository.findAll().get(0);
        Ticket ticket = new Ticket();
        ticket.setNomClient("ELHOUCINE MARIAMI");
        ticket.setPrix(30.00);
        ticket.setCodePayement((int)Math.random()*10000);
        ticket.setPlace(place);
        ticket.setProjectionFilm(projectionFilm);
        ticketRepository.save(ticket);
    }

    @Override
    public void initvilles() {
        Stream.of("Casablanca", "Rabat", "Tanger").forEach(v ->{
            Ville ville = new Ville();
            ville.setName(v);
            villeRepository.save(ville);
        });
    }
}
