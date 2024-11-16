package com.infracow.program.repositories;

import com.infracow.program.models.Analise;
import com.infracow.program.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a LEFT JOIN FETCH a.imagens")
    List<Animal> findAllWithImages();

    @Query("SELECT an From Animal a " +
            "INNER JOIN a.imagens i " +
            "INNER JOIN i.analises an " +
            "WHERE an.dataAnalise >= :startDate " +
            "AND an.dataAnalise <= :endDate " +
            "AND an.resultadosAnalise = 'infectado'")
    List<Analise> findAnimalsAnalisesByDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
