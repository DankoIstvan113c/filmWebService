package hu.film.repositories;

import hu.film.domain.Szinesz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SzineszRepository extends JpaRepository<Szinesz, Integer> {

    List<Szinesz> findAllByOrderByName();
}
