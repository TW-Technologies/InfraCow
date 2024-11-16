package com.infracow.program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infracow.program.models.Imagem;

import java.util.List;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

    @Query("SELECT i from Imagem i WHERE i.animal.id = :animalId ORDER BY i.dataCaptura DESC ")
    List<Imagem> findImagesByAnimal(@Param("animalId") Long animalId);

    default Imagem getLastImageByAnimal(Long animalId){
        List<Imagem> imagens = findImagesByAnimal(animalId);
        return imagens.isEmpty() ? null : imagens.get(0);
    }

}
