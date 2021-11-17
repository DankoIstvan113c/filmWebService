package hu.film.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int hossz;
    @OneToMany(mappedBy = "film")
    @JsonIgnore
    private List<Szinesz> szineszek;

    public Film(){

    }

    public List<Szinesz> getSzineszek() {
        return szineszek;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hossz=" + hossz +
                '}';
    }

    public void setSzineszek(List<Szinesz> szineszek) {
        this.szineszek = szineszek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

}


