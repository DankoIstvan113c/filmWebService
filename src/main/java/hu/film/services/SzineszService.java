package hu.film.services;

import hu.film.domain.Film;
import hu.film.domain.Szinesz;
import hu.film.repositories.FilmRepository;
import hu.film.repositories.SzineszRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SzineszService {

    @Autowired
    private SzineszRepository repository;

    @Autowired
    private FilmRepository filmRepository;

    public List<Szinesz> getSzineszek(){
        return repository.findAllByOrderByName();
    }

    public Szinesz getSzinesz(int id) {
        Optional<Szinesz> szinesz = repository.findById(id);
        if (szinesz.isPresent()){
            return szinesz.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Szinesz addSzinesz(Szinesz szinesz) {
        if(isUnique(szinesz.getName()))
            return repository.save(szinesz);
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    private boolean isUnique(String name) {
        List<Szinesz> szineszek = repository.findAll();
        for (Szinesz szinesz: szineszek) {
            if(szinesz.getName().equals(name))
                return false;
        }
        return true;
    }

    public Szinesz updateSzinesz(int id, int age, int films) {
        Optional<Szinesz> optionalSzinesz = repository.findById(id);
        if (optionalSzinesz.isPresent()){
            Szinesz updatingSzinesz = optionalSzinesz.get();
            updatingSzinesz.setAge(age);
            Optional<Film> optionalFilm = filmRepository.findById(films);
            if(optionalFilm.isPresent()) {
                updatingSzinesz.setFilmek(optionalFilm.get());
                return repository.save(updatingSzinesz);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Szinesz replaceSzinesz(int id, Szinesz szinesz) {
        System.out.println(szinesz);
        Optional<Szinesz> optionalSzinesz = repository.findById(id);
        System.out.println(optionalSzinesz.get());
        if(optionalSzinesz.isPresent()) {
            szinesz.setId(id);
            return repository.save(szinesz);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteSzinesz(int id) {
        Optional<Szinesz> optionalSzinesz = repository.findById(id);
        if (!optionalSzinesz.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }
}