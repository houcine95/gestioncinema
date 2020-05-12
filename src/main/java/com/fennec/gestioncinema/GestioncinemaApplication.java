package com.fennec.gestioncinema;

import com.fennec.gestioncinema.dao.ICinemaInitService;
import com.fennec.gestioncinema.service.cinemaInitServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestioncinemaApplication implements CommandLineRunner {

    @Bean
    public cinemaInitServiceImp cinemaInitService(){
        return new cinemaInitServiceImp();
    }

    public static void main(String[] args) {
        SpringApplication.run(GestioncinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cinemaInitService().initCategories();
        cinemaInitService().initFilms();
        cinemaInitService().initSeances();
        cinemaInitService().initvilles();
        cinemaInitService().initCinemas();
        cinemaInitService().initSalles();
        cinemaInitService().initPlaces();
        cinemaInitService().initProjectionFilms();
        cinemaInitService().initTickets();
    }
}
