package com.infracow.program.repositories;

import com.infracow.program.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a JOIN FETCH a.imagens")
    List<Animal> findAllWithImages();

}
