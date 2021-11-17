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
    private Film films;

    public Szinesz(){

    }


    @Override
    public String toString() {
        return "Szinesz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", filmek=" + films +
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

    public Film getFilmek() {
        return (Film) films;
    }

    public void setFilmek(Film film) {
        this.films = films;
    }

}
