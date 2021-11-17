package hu.film.controllers;

import hu.film.domain.Film;
import hu.film.domain.Szinesz;
import hu.film.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FilmController {

    private FilmService service;

    @Autowired
    public void setService(FilmService service){
        this.service = service;
    }

    @GetMapping("/films")
    public List<Film> getFilms(){
        return service.getFilms();
    }

    @GetMapping("/films/{id}")
    public Film getFilm(@PathVariable("id") int id){
        return service.getFilm(id);
    }

    @GetMapping("/films/{id}/szineszek")
    public List<Szinesz> getSzineszekInFilm(@PathVariable("id") int id){
        return  service.getSzineszekInFilm(id);
    }

    @PostMapping("/films")
    @ResponseStatus(HttpStatus.CREATED)
    public Film addFilm(@RequestBody Film film){
        return service.addFilm(film);
    }

    @DeleteMapping("films/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        service.deleteFilm(id);
    }

    @PatchMapping("films/{id}/{hossz}")
    public void updateCategory(@PathVariable("id") int id, @PathVariable("hossz") int hossz) {
        service.updateFilm(id, hossz);
    }

}
