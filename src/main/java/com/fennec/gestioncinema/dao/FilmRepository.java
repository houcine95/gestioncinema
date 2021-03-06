package com.fennec.gestioncinema.dao;

import com.fennec.gestioncinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {

    public Film findByTitre(String titre);
}
