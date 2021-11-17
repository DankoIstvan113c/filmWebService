package hu.film.services;

import hu.film.domain.Film;
import hu.film.domain.Szinesz;
import hu.film.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository repository;

    public List<Film> getFilms(){
        return repository.findAll();
    }

    public Film getFilm(int id) {
        Optional<Film> film = repository.findById(id);
        if (film.isPresent()){
            return film.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Szinesz> getSzineszekInFilm(int id) {
        Optional<Film> film = repository.findById(id);
        if(film.isPresent()) {
            return film.get().getSzineszek();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Film addFilm(Film film) {
        if(isUnique(film.getName()))
            return repository.save(film);
            throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    private boolean isUnique(String name) {
        List<Film> films = repository.findAll();
        for (Film film : films) {
            if (film.getName().equals(name))
                return false;
        }
        return true;
    }

    public void deleteFilm(int id) {
        Optional<Film> film = repository.findById(id);
        if (film.isPresent()){
            repository.deleteById(id);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void updateFilm(int id, int hossz) {
        Optional<Film> optionalFilm = repository.findById(id);
        if (optionalFilm.isPresent()){
            Film category = optionalFilm.get();
            category.setHossz(hossz);
            repository.save(category);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
