package hu.film.domain;

import javax.persistence.*;

@Entity
public class Szinesz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @ManyToOne
    private Film film;

    public Szinesz(){

    }


    @Override
    public String toString() {
        return "Szinesz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", film=" + film +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}
