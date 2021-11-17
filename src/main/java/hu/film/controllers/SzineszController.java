package hu.film.controllers;


import hu.film.domain.Film;
import hu.film.domain.Szinesz;
import hu.film.services.SzineszService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SzineszController {

    private SzineszService service;

    public SzineszController(SzineszService service){
        this.service = service;
    }

    @GetMapping("/szineszek")
    public List<Szinesz> getszineszek(){
        return service.getSzineszek();
    }

    @GetMapping("/szineszek/{id}")
    public Szinesz getSzineszek(@PathVariable("id") int id){
        return service.getSzinesz(id);
    }

    @PostMapping("/szineszek")
    @ResponseStatus(HttpStatus.CREATED)
    public Szinesz addSzinesz(@RequestBody Szinesz szinesz){
        return service.addSzinesz(szinesz);
    }

    @PatchMapping("/szineszek/{id}/{age}/{films}")
    public Szinesz updateSzinesz(@PathVariable ("id") int id, @PathVariable("age") int age, @PathVariable("films") int films){
        return service.updateSzinesz(id, age, films);

    }

    @PutMapping("/szineszek/{id}")
    public Szinesz replaceSzinesz(@PathVariable("id") int id, @RequestBody Szinesz szinesz) {
        return service.replaceSzinesz(id, szinesz);
    }

    @RequestMapping(method=RequestMethod.DELETE, path="szineszek/{id}")
    public void deleteSzinesz(@PathVariable("id") int id) {
        service.deleteSzinesz(id);
    }
}
